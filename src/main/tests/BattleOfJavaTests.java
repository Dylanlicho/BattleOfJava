import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import sample.model.BattleOfJava;
import sample.model.player.Player;
import sample.model.ship.Ship;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BattleOfJavaTests {

    @Test
    void setShipPositionNegativeCoordinates() {

        BattleOfJava boj = new BattleOfJava();
        Player p = EasyMock.createMock(Player.class);
        Ship s = EasyMock.createMock(Ship.class);
        assertDoesNotThrow(() -> {
            boj.setShipPosition(p, s, -10, -10);
        });
        
    }

}
