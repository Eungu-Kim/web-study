package home.work10_21;

import java.util.*;

public class LottoLunchMate {
    public static void main(String[] args) {
        String[] nameArray = {
                "강민형", "강은혜", "강주성", "고아라", "김규남",
                "김민석", "김우연", "김은수", "박달", "박자은",
                "서승아", "성원호", "신유진", "신혜지", "안태현",
                "엄희진", "이건", "이상민", "이슬기", "이영호",
                "이자영", "이주희", "임현섭", "전나영", "전정배",
                "차현수", "황정민"
        };

        List<String> names = new ArrayList<>(Arrays.asList(nameArray));
        Random rand = new Random();
        try (Scanner sc = new Scanner(System.in)) {

            int[] groupSizes = {5, 5, 5, 6, 6};

            System.out.println(" 점심 메이트 추첨을 시작합니다! (엔터를 눌러주세요)");

            for (int i = 0; i < groupSizes.length; i++) {
                System.out.println("\n" + (i + 1) + "조 추첨을 시작하려면 엔터를 눌러주세요");
                sc.nextLine();

                int groupSize = groupSizes[i];
                List<String> group = new ArrayList<>();

                for (int j = 0; j < groupSize; j++) {
                    int randomIndex = rand.nextInt(names.size());
                    group.add(names.remove(randomIndex));
                }

                System.out.println("당첨!" + (i + 1) + "조 (" + groupSize + "명): " + group);
            }
        }

        System.out.println("\n 즐거운 점심시간 되세요!");
    }
}
