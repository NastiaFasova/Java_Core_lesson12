package task2;

public enum Month {
	JANUARY(31, Seasons.WINTER), FEBRUARY(28, Seasons.WINTER), MARCH(31, Seasons.SPRING), APRIL(30, Seasons.SPRING),
	MAY(31, Seasons.SPRING), JUNE(30, Seasons.SUMMER), JULY(31, Seasons.SUMMER), AUGUST(31, Seasons.SUMMER),
	SEPTEMBER(30, Seasons.FALL), OCTOBER(31, Seasons.FALL), NOVEMBER(30, Seasons.FALL),
	DECEMBER(31, Seasons.WINTER);

	Seasons seasons;
	private int days;

	Month(int days, Seasons seasons) {
		this.seasons = seasons;
		this.days=days;
	}

	public int getDays() {
		return days;
	}

	public Seasons getSeasons() {
		return seasons;
	}
}
