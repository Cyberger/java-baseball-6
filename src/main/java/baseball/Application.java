package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game = true;
        while(game) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            int strike = 0, ball = 0;
            while(strike!=3){
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if(input.length() != 3){
                    throw new IllegalArgumentException();
                }
                List<Integer> numinput = new ArrayList<>();
                for(char digit : input.toCharArray()){
                    numinput.add(Character.getNumericValue(digit));
                }
                for(int i=0;i<3;i++){
                    if(computer.get(i)==numinput.get(i)){
                        strike++;
                    }
                    else if(numinput.contains(computer.get(i))){
                        ball++;
                    }
                }
                if(strike==3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String regame = Console.readLine();
                    if(regame.equals("1")){
                        game = true;
                    }
                    else if(regame.equals("2")){
                        game = false;
                    }
                    break;
                }
                else{
                    if(strike>0&&ball>0){
                        System.out.println(ball+"볼"+strike+"스트라이크");
                    }
                    else if(strike==0&&ball>0){
                        System.out.println(ball+"볼");
                    }
                    else if(strike>0&&ball==0){
                        System.out.println(strike+"스트라이크");
                    }
                    else if(strike==0&&ball==0){
                        System.out.println("낫싱");
                    }
                }
            }





        }


    }
}
