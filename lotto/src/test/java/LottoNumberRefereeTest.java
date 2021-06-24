import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberRefereeTest {

    LottoNumberReferre lottoNumberReferre = new LottoNumberReferre();

    @Test
    @DisplayName("기본 로또 6개 숫자에서 일치하는 숫자 개수 반환")
    public void compareBasicLottoNumber() throws Exception
    {
        //given
        List<Integer> basicLottoNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));
        List<Integer> userSelectedNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        //when
        int count = lottoNumberReferre.compareBasicLottoNumbers(basicLottoNumbers,userSelectedNumbers);
        //then
        assertEquals(count,5);
    }

    @Test
    @DisplayName("뽑은 6개 숫자중 보너스 숫자 개수 출력")
    public void compareBonusLottoNumber() throws Exception
    {
        //given
        Integer bonusNumber = 3;
        List<Integer> userSelectedNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        //when
        int count = lottoNumberReferre.compareBonusLottoNumber(bonusNumber,userSelectedNumbers);
        //then
        assertEquals(count,1);
    }

    @Test
    @DisplayName("참가자가 몇 등인지 출력")
    public void getUserLottoRank() throws Exception
    {
        //given
        List<Integer> basicLottoNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));
        Integer bonusNumber = 6;
        List<Integer> userSelectedNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));
        //when
        String rank = lottoNumberReferre.getUserLottoRank(basicLottoNumbers,bonusNumber,userSelectedNumbers);
        //then
        assertEquals(rank,"1등");
    }
}
