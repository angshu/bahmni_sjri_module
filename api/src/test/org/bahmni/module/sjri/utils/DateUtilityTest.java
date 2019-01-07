package org.bahmni.module.sjri.utils;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;

public class DateUtilityTest {
  @Test
  public void shouldParseDate() throws ParseException {
    Date date = DateUtility.parseDate("2018-12-12");
    Assert.assertNotNull(date);
  }

  @Test(expected = ParseException.class)
  public void shouldNotParseInvalidDate() throws ParseException {
    DateUtility.parseDate("2018-24-12");
  }

  @Test
  public void shouldGiveNullWhenGivenDateStringIsNull() throws ParseException {
    Assert.assertNull(DateUtility.parseDate(null));
  }

  @Test
  public void shouldGiveAddNoOfDaysAskedToAdd() throws ParseException {
    Date date = DateUtility.parseDate("2018-12-10");
    Date expectedDate = DateUtility.parseDate("2018-12-17");
    Assert.assertEquals(DateUtility.addDays(date, 7), expectedDate);
  }

  @Test
  public void shouldVerifyEndDateLaterThanStartDate() throws ParseException {
    int result = DateUtility.compare(DateUtility.parseDate("2018-01-12"), DateUtility.parseDate("2018-02-12"));
    Assert.assertTrue("startDate should be less than endDate. Actual: " + result, result < 0);

    result = DateUtility.compare(DateUtility.parseDate("2018-02-12"), DateUtility.parseDate("2018-02-11"));
    Assert.assertTrue("startDate should be greater than endDate. Actual: " + result, result > 0);

    result = DateUtility.compare(DateUtility.parseDate("2018-02-12"), DateUtility.parseDate("2018-02-12"));
    Assert.assertTrue("startDate should be equal to endDate. Actual: " + result, result == 0);
  }

  @Test
  public void shouldGetStartOfWeekWhenDateIsGiven() throws ParseException {
    Date result = DateUtility.getWeekStart(DateUtility.parseDate("2018-07-25"), 3);
    Assert.assertEquals(DateUtility.parseDate("2018-07-24"), result);
  }

  @Test
  public void shouldGiveFalseWhenGivenListConsistsOneInvalidTimeString() {
    ArrayList<String> timings = new ArrayList<>();
    timings.add("12:30");
    timings.add("29:30");
    Assert.assertFalse(DateUtility.areAllValidTimeStrings(timings));
  }

  @Test
  public void shouldGiveTrueWhenGivenListConsistsAllValidTimeString() {
    ArrayList<String> timings = new ArrayList<>();
    timings.add("10:30");
    timings.add("12:30");
    timings.add("16:30");
    Assert.assertTrue(DateUtility.areAllValidTimeStrings(timings));
  }

  @Test
  public void shouldGiveTrueWhenGivenEmptyList() {
    ArrayList<String> timings = new ArrayList<>();
    Assert.assertTrue(DateUtility.areAllValidTimeStrings(timings));
  }

  @Test
  public void shouldGiveTrueWhenGivenDateIsSameAsStartDate() throws ParseException {
    Date startDate = DateUtility.parseDate("2018-12-10");
    Date endDate = DateUtility.parseDate("2018-12-13");
    Assert.assertTrue(DateUtility.isBetween(startDate, endDate, startDate));
  }

  @Test
  public void shouldGiveFalseWhenGivenDateIsBeforeStartDate() throws ParseException {
    Date givenDate = DateUtility.parseDate("2018-12-9");
    Date startDate = DateUtility.parseDate("2018-12-10");
    Date endDate = DateUtility.parseDate("2018-12-13");
    Assert.assertFalse(DateUtility.isBetween(startDate, endDate, givenDate));
  }

  @Test
  public void shouldGiveTrueWhenGivenDateIsAfterStartDateAndBeforeEndDate() throws ParseException {
    Date givenDate = DateUtility.parseDate("2018-12-12");
    Date startDate = DateUtility.parseDate("2018-12-10");
    Date endDate = DateUtility.parseDate("2018-12-13");
    Assert.assertTrue(DateUtility.isBetween(startDate, endDate, givenDate));
  }

  @Test
  public void shouldGiveTrueWhenGivenDateIsSameAsEndDate() throws ParseException {
    Date givenDate = DateUtility.parseDate("2018-12-13");
    Date startDate = DateUtility.parseDate("2018-12-10");
    Date endDate = DateUtility.parseDate("2018-12-13");
    Assert.assertTrue(DateUtility.isBetween(startDate, endDate, givenDate));
  }

  @Test
  public void shouldGiveFalseWhenGivenDateAfterEndDate() throws ParseException {
    Date givenDate = DateUtility.parseDate("2018-12-14");
    Date startDate = DateUtility.parseDate("2018-12-10");
    Date endDate = DateUtility.parseDate("2018-12-13");
    Assert.assertFalse(DateUtility.isBetween(startDate, endDate, givenDate));
  }

  @Test
  public void shouldGiveEmptyListWhenGivenDayDoesNotComeEvenOnceBetweenStartDateAndEndDate() throws ParseException {
    Date startDate = DateUtility.parseDate("2018-08-08");
    Date endDate = DateUtility.parseDate("2018-08-09");
    ArrayList<Date> expectedDates = new ArrayList<>();
    Assert.assertEquals(DateUtility.getAllDatesBetweenOf(DayOfWeek.MONDAY, startDate, endDate), expectedDates);
  }

  @Test
  public void shouldGiveAllDatesOfTheGivenDayBetweenStartDateAndEndDate() throws ParseException {
    Date startDate = DateUtility.parseDate("2018-08-04");
    Date endDate = DateUtility.parseDate("2018-08-22");
    ArrayList<Date> expectedDates = new ArrayList<>();
    expectedDates.add(DateUtility.parseDate("2018-08-06"));
    expectedDates.add(DateUtility.parseDate("2018-08-13"));
    expectedDates.add(DateUtility.parseDate("2018-08-20"));
    Assert.assertEquals(DateUtility.getAllDatesBetweenOf(DayOfWeek.MONDAY, startDate, endDate), expectedDates);
  }

  @Test
  public void shouldGiveAllDatesOfSundayBetweenStartDateAndEndDate() throws ParseException {
    Date startDate = DateUtility.parseDate("2018-08-04");
    Date endDate = DateUtility.parseDate("2018-08-22");
    ArrayList<Date> expectedDates = new ArrayList<>();
    expectedDates.add(DateUtility.parseDate("2018-08-05"));
    expectedDates.add(DateUtility.parseDate("2018-08-12"));
    expectedDates.add(DateUtility.parseDate("2018-08-19"));
    Assert.assertEquals(DateUtility.getAllDatesBetweenOf(DayOfWeek.SUNDAY, startDate, endDate), expectedDates);
  }
}
