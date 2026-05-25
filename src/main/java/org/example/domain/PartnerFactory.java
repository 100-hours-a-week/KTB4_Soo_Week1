package org.example.domain;

public class PartnerFactory {
    public static DatingPartner createPartner(int choice, Player player) {
        return switch (choice) {
            case 1 -> new ExtrovertedPartner("김민지", player);
            case 2 -> new IntrovertedPartner("윤서아", player);
            case 3 -> new ExtremelyShyPartner("이지수", player);
            case 4 -> new ObsessivePartner("이지아", player);
            default -> new ExtremelyShyPartner("이지수", player); // 방어적 설계
        };
    }
}
