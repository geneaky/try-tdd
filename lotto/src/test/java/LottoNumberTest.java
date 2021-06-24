import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    private LottoNumber lottoNumber = new LottoNumber();

    @Test
    @DisplayName("공 6개 생성")
    public void ballCreate() throws Exception
    {
        //given
        List<Integer> lottoNumbers = lottoNumber.createBasicLottoNumbers();
        //when

        //then
        assertEquals(lottoNumbers.size(),6);
    }

    @Test
    @DisplayName("생성된 공의 범위는 1~42사이")
    @RepeatedTest(100)
    public void checkBallRange() throws Exception
    {
        //given
        List<Integer> lottoNumbers = lottoNumber.createBasicLottoNumbers();
        //when

        //then
        assertAll(
                () -> {
                    for(Integer lottoNumber: lottoNumbers){
                        assertTrue(1<=lottoNumber&&lottoNumber<=42);
                    }
                }
        );
    }

    @Test
    @DisplayName("공 6개가 중복되지 않음")
    @RepeatedTest(100)
    public void ballsNotDuplicate() throws Exception
    {
        //given
        List<Integer> lottoNumbers = lottoNumber.createBasicLottoNumbers();
        //when
        Map<String,Integer> map = new HashMap<>();
        for(Integer lottoNumber: lottoNumbers){
            map.put(lottoNumber.toString(),lottoNumber);
        }
        //then
        assertEquals(map.size(),6);
    }

    @Test
    @DisplayName("보너스 번호 1개는 기본 6개의 번호와 중복되지 않음")
    @RepeatedTest(100)
    public void serviceNumberNotDuplicateBasicNumber() throws Exception
    {
        //given
        List<Integer> lottoNumbers = lottoNumber.createBasicLottoNumbers();
        //when
        Integer bonusNumber = lottoNumber.createBonusLottoNumber();
        //then
        assertAll(()->{
            for(Integer lottoNumber: lottoNumbers){
                assertNotEquals(bonusNumber,lottoNumber);
            }
        });
    }


}