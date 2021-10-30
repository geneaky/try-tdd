import java.util.List;

public class Simulation {

    int simulationCount;
    LottoNumber lottoNumber;
    LottoNumberReferre lottoNumberReferre;


    public Simulation(int simulationCount) {
        this.simulationCount = simulationCount;
        this.lottoNumber = new LottoNumber();
        this.lottoNumberReferre = new LottoNumberReferre();
    }


    public String[] getResult(){
        String[] simulationResult = new String[simulationCount];
        List<Integer> lottoResultNumbers = lottoNumber.createBasicLottoNumbers();
        int lottoBonusNumber = lottoNumber.createBonusLottoNumber();
        for(int i = 0;i<simulationCount;i++){
            List<Integer> autoGeneratedNumbers = lottoNumber.lottoAutoGenerator();
            simulationResult[i] = lottoNumberReferre.getUserLottoRank(lottoResultNumbers, lottoBonusNumber, autoGeneratedNumbers);
        }
        return simulationResult;
    }


}