package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private TorpedoStore mockSec; 
  private TorpedoStore mockPri; 

  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockPri = mock(TorpedoStore.class);
    mockSec = mock(TorpedoStore.class); 
    this.ship = new GT4500(mockPri, mockSec); 
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
     
    when(mockPri.getTorpedoCount()).thenReturn(10); 

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(result, times(1)).equals(true); 
    //assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockPri.getTorpedoCount()).thenReturn(10);
    when(mockPri.getTorpedoCount()).thenReturn(10);

    mockSec = new TorpedoStore(10); 
    when(mockSec.getTorpedoCount()).thenReturn(10);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(result, times(1)).equals(true);
  }

 @Test
 public void fireTorpedo_All_SecondStroeIsEmpthy(){
    // Arrange
    when(mockPri.getTorpedoCount()).thenReturn(10);
    when(mockSec.getTorpedoCount()).thenReturn(0);

    boolean result = ship.fireTorpedo(FiringMode.ALL);
    
    verify(result, times(1)).equals(false);
 } 

@Test
public void fireTorpedo_Single_FailreDetecded(){
    when(mockPri.getTorpedoCount()).thenReturn(10); 

    boolean result = ship.fireTorpedo(FiringMode.ALL);

    verify(result, times(1)).equals(false);
}  

}
