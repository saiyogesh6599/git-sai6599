package Project1.UberX.Strategies;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import Project1.UberX.Strategies.Impl.DriverMatchingNearestDriverStrategyServiceImpl;
import Project1.UberX.Strategies.Impl.DriverMatchingNearestTopRatingDriverServiceImpl;
import Project1.UberX.Strategies.Impl.RideFareCalStrategyBestRateServiceImpl;
import Project1.UberX.Strategies.Impl.RideFareSurgeCalStrategyServiceImpl;
import Project1.UberX.Strategies.Impl.RiderFareDefaultFareCalculationServiceImpl;

@Component
public class RideStrategyManager {

	private DriverMatchingNearestDriverStrategyServiceImpl driverMatchingNearestDriverStrategyServiceImpl;
	private RideFareCalStrategyBestRateServiceImpl rideFareCalStrategyBestRateServiceImpl;
	private RideFareSurgeCalStrategyServiceImpl rideFareSurgeCalStrategyServiceImpl;
	private RiderFareDefaultFareCalculationServiceImpl riderFareDefaultFareCalculationServiceImpl;
	private DriverMatchingNearestTopRatingDriverServiceImpl driverMatchingNearestTopRatingDriverServiceImpl;
	public DriverMatchingNearestDriverStrategyServiceImpl getDriverMatchingNearestDriverStrategyServiceImpl() {
		return driverMatchingNearestDriverStrategyServiceImpl;
	}
	public void setDriverMatchingNearestDriverStrategyServiceImpl(
			DriverMatchingNearestDriverStrategyServiceImpl driverMatchingNearestDriverStrategyServiceImpl) {
		this.driverMatchingNearestDriverStrategyServiceImpl = driverMatchingNearestDriverStrategyServiceImpl;
	}
	public RideFareCalStrategyBestRateServiceImpl getRideFareCalStrategyBestRateServiceImpl() {
		return rideFareCalStrategyBestRateServiceImpl;
	}
	public RideStrategyManager(
			DriverMatchingNearestDriverStrategyServiceImpl driverMatchingNearestDriverStrategyServiceImpl,
			RideFareCalStrategyBestRateServiceImpl rideFareCalStrategyBestRateServiceImpl,
			RideFareSurgeCalStrategyServiceImpl rideFareSurgeCalStrategyServiceImpl,
			RiderFareDefaultFareCalculationServiceImpl riderFareDefaultFareCalculationServiceImpl) {
		this.driverMatchingNearestDriverStrategyServiceImpl = driverMatchingNearestDriverStrategyServiceImpl;
		this.rideFareCalStrategyBestRateServiceImpl = rideFareCalStrategyBestRateServiceImpl;
		this.rideFareSurgeCalStrategyServiceImpl = rideFareSurgeCalStrategyServiceImpl;
		this.riderFareDefaultFareCalculationServiceImpl = riderFareDefaultFareCalculationServiceImpl;
	}
	public void setRideFareCalStrategyBestRateServiceImpl(
			RideFareCalStrategyBestRateServiceImpl rideFareCalStrategyBestRateServiceImpl) {
		this.rideFareCalStrategyBestRateServiceImpl = rideFareCalStrategyBestRateServiceImpl;
	}
	public RideFareSurgeCalStrategyServiceImpl getRideFareSurgeCalStrategyServiceImpl() {
		return rideFareSurgeCalStrategyServiceImpl;
	}
	public void setRideFareSurgeCalStrategyServiceImpl(
			RideFareSurgeCalStrategyServiceImpl rideFareSurgeCalStrategyServiceImpl) {
		this.rideFareSurgeCalStrategyServiceImpl = rideFareSurgeCalStrategyServiceImpl;
	}
	public RiderFareDefaultFareCalculationServiceImpl getRiderFareDefaultFareCalculationServiceImpl() {
		return riderFareDefaultFareCalculationServiceImpl;
	}
	public void setRiderFareDefaultFareCalculationServiceImpl(
			RiderFareDefaultFareCalculationServiceImpl riderFareDefaultFareCalculationServiceImpl) {
		this.riderFareDefaultFareCalculationServiceImpl = riderFareDefaultFareCalculationServiceImpl;
	}
	
	public DriverMatchingStrategy driverMatchingStartegy(double riderRating) {
		if (riderRating >=4.8) {
		return 	driverMatchingNearestTopRatingDriverServiceImpl;
		}else {
			return driverMatchingNearestDriverStrategyServiceImpl;
		}
	}
	public RideFareCalStartegy rideFareCalStartegy () {
		
		LocalTime surgeStartTime=LocalTime.of(18, 0);
		LocalTime surgeEndTime=LocalTime.of(21, 0);
		LocalTime currentTime=LocalTime.now();
		
		boolean isSurgeTime=currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
		
		if (isSurgeTime) {
			return rideFareSurgeCalStrategyServiceImpl;
		}
		return rideFareCalStrategyBestRateServiceImpl;
		
		
	}
	
}
