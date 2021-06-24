import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoLankTest {

    @Test
    @DisplayName("일치하는 번호에 따른 등수 판별")
    public void judgeRank() throws Exception
    {
        //given
        LottoLank lottoLank1 = LottoLank.valueOf(6,0);
        LottoLank lottoLank2 = LottoLank.valueOf(5,0);
        LottoLank lottoLank3 = LottoLank.valueOf(5,1);
        LottoLank lottoLank4 = LottoLank.valueOf(4,0);
        LottoLank lottoLank5 = LottoLank.valueOf(3,0);
        LottoLank lottoLank6 = LottoLank.valueOf(2,0);
        //when

        //then
        assertEquals(lottoLank1.getRankName(),"1등");
        assertEquals(lottoLank2.getRankName(),"2등");
        assertEquals(lottoLank3.getRankName(),"3등");
        assertEquals(lottoLank4.getRankName(),"4등");
        assertEquals(lottoLank5.getRankName(),"5등");
        assertEquals(lottoLank6.getRankName(),"해당없음");
    }

}