package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */
public class Moscow extends CityObserver {
    private final int utcOffset;
    private TimeSubject timeSubject;
    private DaylightSavingTime dstStatus;
    private int localHourOfTime;

    private Moscow(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
        this.timeSubject = timeSubject;
    }

    public static Moscow newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Moscow(utcOffset, dstStatus, timeSubject);
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
        return "Moscow";
    }
    @Override
    public String getLocalHourOfTime() {
        return Integer.toString(this.localHourOfTime);
    }
}
