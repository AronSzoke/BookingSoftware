package hu.ak_akademia.shc.servlets.search;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.shc.db.SearchDao;
import hu.ak_akademia.shc.entities.SearchParameters;
import hu.ak_akademia.shc.entities.SearchResults;
import hu.ak_akademia.shc.preparedstatementwriter.select.SelectSearchResultPreparedStatementWriter;
import hu.ak_akademia.shc.resultsetreader.SearchResultSetReader;
import hu.ak_akademia.shc.servlets.search.validator.AddressValidator;
import hu.ak_akademia.shc.servlets.search.validator.DoubleDateValidator;
import hu.ak_akademia.shc.servlets.search.validator.DoublePriceValidator;
import hu.ak_akademia.shc.servlets.search.validator.NumberOfGuestsValidator;
import hu.ak_akademia.shc.servlets.search.validator.SearchValidator;
import hu.ak_akademia.shc.servlets.search.validator.SingleDateValidator;
import hu.ak_akademia.shc.servlets.search.validator.SinglePriceValidator;
import hu.ak_akademia.shc.servlets.search.validator.ValidationResult;
import hu.ak_akademia.shc.sqlbuilder.select.SelectSearchResultSqlBuilder;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String priceFrom = request.getParameter("priceFrom");
		String priceTo = request.getParameter("priceTo");
		String address = request.getParameter("address");
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		String adults = request.getParameter("numberOfGuests");

		boolean allSuccessful = true;

		SearchValidator priceFromValidator = new SinglePriceValidator(priceFrom);
		ValidationResult priceFromResult = priceFromValidator.validate();
		allSuccessful &= priceFromResult.isSuccessful();
		request.setAttribute("priceFromResult", priceFromResult);

		SearchValidator priceToValidator = new SinglePriceValidator(priceTo);
		ValidationResult priceToResult = priceToValidator.validate();
		allSuccessful &= priceToResult.isSuccessful();
		request.setAttribute("priceToResult", priceToResult);

		if (priceFromResult.isSuccessful() && priceToResult.isSuccessful() && !priceFrom.isEmpty() && !priceTo.isEmpty()) {
			SearchValidator priceRangeValidator = new DoublePriceValidator(Integer.parseInt(priceFrom), Integer.parseInt(priceTo));
			ValidationResult doublePriceResult = priceRangeValidator.validate();
			allSuccessful &= doublePriceResult.isSuccessful();
			request.setAttribute("doublePriceResult", doublePriceResult);
		}

		SearchValidator dateFromVaLidator = new SingleDateValidator(dateFrom);
		ValidationResult dateFromResult = dateFromVaLidator.validate();
		allSuccessful &= dateFromResult.isSuccessful();
		request.setAttribute("dateFromResult", dateFromResult);

		SearchValidator dateToValidator = new SingleDateValidator(dateTo);
		ValidationResult dateToResult = dateToValidator.validate();
		allSuccessful &= dateToResult.isSuccessful();
		request.setAttribute("dateToResult", dateToResult);

		if (dateFromResult.isSuccessful() && dateToResult.isSuccessful()) {
			SearchValidator dateRangeValidator = new DoubleDateValidator(LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
			ValidationResult doubleDateResult = dateRangeValidator.validate();
			allSuccessful &= doubleDateResult.isSuccessful();
			request.setAttribute("doubleDateResult", doubleDateResult);
		}

		SearchValidator addressValidator = new AddressValidator(address);
		ValidationResult addressResult = addressValidator.validate();
		allSuccessful &= addressResult.isSuccessful();
		request.setAttribute("addressResult", addressResult);

		SearchValidator numberOfGuestsValidator = new NumberOfGuestsValidator(adults);
		ValidationResult numberOfGuestsResult = numberOfGuestsValidator.validate();
		allSuccessful &= numberOfGuestsResult.isSuccessful();
		request.setAttribute("numberOfGuestsResult", numberOfGuestsResult);

		if (allSuccessful) {
			SearchDao searchDao = new SearchDao();
			SearchParameters.Builder searchParameterBuilder = SearchParameters.builder()
					.withAddress(address)
					.withDateFrom(LocalDate.parse(dateFrom))
					.withDateTo(LocalDate.parse(dateTo))
					.withAdults(Integer.parseInt(adults));

			boolean withPriceFrom = !priceFrom.isEmpty();
			if (withPriceFrom) {
				searchParameterBuilder.withPriceFrom(Integer.parseInt(priceFrom));
			}
			boolean withPriceTo = !priceTo.isEmpty();
			if (withPriceTo) {
				searchParameterBuilder.withPriceTo(Integer.parseInt(priceTo));
			}

			SearchParameters searchParameters = searchParameterBuilder.build();
			List<SearchResults> searchResults = searchDao.retrieve(new SelectSearchResultSqlBuilder(withPriceFrom, withPriceTo), new SelectSearchResultPreparedStatementWriter(searchParameters), new SearchResultSetReader());
			request.setAttribute("searchResults", searchResults);
			request.setAttribute("dateFrom", dateFrom);
			request.setAttribute("dateTo", dateTo);
			long nights = ChronoUnit.DAYS.between(LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
			request.setAttribute("nights", nights);
			request.getRequestDispatcher("searchresult.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("search.jsp")
					.forward(request, response);
		}

	}
}
