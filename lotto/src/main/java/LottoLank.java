public enum LottoLank {
    FIRST_PLACE(6,"1등"),
    SECOND_PLACE(5,"2등"),
    THIRED_PLACE(5,"3등"),
    FOURTH_PLACE(4,"4등"),
    FIFTH_PLACE(3,"5등"),
    NO_PLACE(0,"해당없음");

    private int matchCount;
    private String rankName;

    LottoLank(int matchCount, String rankName) {
        this.matchCount = matchCount;
        this.rankName = rankName;
    }

    public static LottoLank valueOf(int basicCount,int bonusCount){
        if(basicCount == LottoLank.SECOND_PLACE.matchCount){
            if(bonusCount==0){
                return LottoLank.SECOND_PLACE;
            }
            return LottoLank.THIRED_PLACE;
        }

        for(LottoLank rank: LottoLank.values()){
            if(rank.matchCount == basicCount){
                return rank;
            }
        }
        return NO_PLACE;
    }

    public String getRankName(){
        return rankName;
    }
}
