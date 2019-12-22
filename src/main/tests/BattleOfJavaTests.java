//import org.easymock.EasyMock;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import sample.model.BattleOfJava;
//import sample.model.player.Player;
//import sample.model.ship.Ship;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//
//public class BattleOfJavaTests {
//
//    @Test
//    void setShipPositionNullPlayer() {
//
//        BattleOfJava boj = new BattleOfJava();
//        Ship s = EasyMock.createMock(Ship.class);
//        assertDoesNotThrow(() -> {
//            boj.setShipPosition(null, s, 0, 0);
//        });
//
//    }
//
//    @Test
//    void setShipPositionNullShip() {
//
//        BattleOfJava boj = new BattleOfJava();
//        Player p = EasyMock.createMock(Player.class);
//        assertDoesNotThrow(() -> {
//            boj.setShipPosition(p, null, 0, 0);
//        });
//
//    }
//
//    @Test
//    void setShipPositionNegativeCoordinates() {
//
//        BattleOfJava boj = new BattleOfJava();
//        Player p = EasyMock.createMock(Player.class);
//        Ship s = EasyMock.createMock(Ship.class);
//        assertDoesNotThrow(() -> {
//            boj.setShipPosition(p, s, -10, -10);
//        });
//
//    }
//
//    @Test
//    void setShipPositionTooBigCoordinates() {
//
//        BattleOfJava boj = new BattleOfJava();
//        Player p = EasyMock.createMock(Player.class);
//        Ship s = EasyMock.createMock(Ship.class);
//        assertDoesNotThrow(() -> {
//            boj.setShipPosition(p, s, 10000000, 10000000);
//        });
//    }
//
//    @Test
//    void startNewGameBadCentury() {
//
//        BattleOfJava boj = new BattleOfJava();
//        assertDoesNotThrow(() -> {
//            boj.startNewGame(-10, 0);
//        });
//
//    }
//
//    @Test
//    void startNewGameBadTactics() {
//
//        BattleOfJava boj = new BattleOfJava();
//        assertDoesNotThrow(() -> {
//            boj.startNewGame(15, -10);
//        });
//
//    }
//
//    @Test
//    void shootNegativeCoordinates() {
//        BattleOfJava boj = new BattleOfJava();
//        Player p = EasyMock.createMock(Player.class);
//        assertDoesNotThrow(() -> {
//            boj.shoot(p,-10, -10);
//        });
//    }
//
//    @Test
//    void shootTooBigCoordinates() {
//        BattleOfJava boj = new BattleOfJava();
//        Player p = EasyMock.createMock(Player.class);
//        assertDoesNotThrow(() -> {
//            boj.shoot(p,10000000, 10000000);
//        });
//    }
//
//    @Test
//    void shootNullPlayer() {
//        BattleOfJava boj = new BattleOfJava();
//        assertDoesNotThrow(() -> {
//            boj.shoot(null,0, 0);
//        });
//    }
//
//}
