import java.util.List;

public class LottoNumberReferre {

    public int compareBasicLottoNumbers(List<Integer> basicLottoNumbers, List<Integer> userSelectedNumbers) {
        int count = 0;
        for(int i=0;i<LottoNumber.LOTTO_NUMBER_COUNT;i++){
            if(basicLottoNumbers.get(i)==userSelectedNumbers.get(i)) count++;
        }

        return count;
    }

    public int compareBonusLottoNumber(Integer bonusNumber, List<Integer> userSelectedNumbers) {
        for(Integer userSelectedNumber: userSelectedNumbers){
            if(bonusNumber==userSelectedNumber) return 1;
        }
        return 0;
    }

    public String getUserLottoRank(List<Integer> basicLottoNumbers, Integer bonusNumber, List<Integer> userSelectedNumbers) {

        int basicCount = compareBasicLottoNumbers(basicLottoNumbers,userSelectedNumbers);
        int bonusCount = compareBonusLottoNumber(bonusNumber,userSelectedNumbers);

        LottoLank lottoLank = LottoLank.valueOf(basicCount,bonusCount);

        return lottoLank.getRankName();
    }
}
