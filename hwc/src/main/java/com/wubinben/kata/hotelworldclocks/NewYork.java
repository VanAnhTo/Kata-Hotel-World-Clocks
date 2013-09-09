package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class NewYork extends CityObserver {
    private final int utcOffset;
    protected TimeSubject timeSubject;
    private DaylightSavingTime dstStatus;
    private int localHourOfTime;

    public NewYork(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static NewYork newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new NewYork(utcOffset, dstStatus);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        this.localHourOfTime = localHourOfTime;
        this.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(this.localHourOfTime,
                this.utcOffset, this.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        this.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, utcOffset, dstStatus);
    }

    @Override
    public String printCityName() {
        return "New York";
    }
}
