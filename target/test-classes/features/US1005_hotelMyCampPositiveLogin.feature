Feature: US1005 dogru kullanici adi ve sifre ile giris yapilabilmeli

  @hmc
  Scenario: Tc08 positive login test
    Given kullanici "HMCUrl" anasayfasinda
    Then Log in yazisina tiklar
    And gecerli username girer
    And gecerli password girer
    And Login butonuna basar
    Then sayfaya giris yaptigini kontrol eder
    And sayfayi kapatir
