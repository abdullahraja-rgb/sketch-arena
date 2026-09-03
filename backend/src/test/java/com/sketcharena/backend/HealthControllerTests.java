package com.sketcharena.backend.health;

// unit testing and assertion imports 
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class HealthControllerTests {
    private final HealthController controller = new HealthController();

    @Test
    // calls the health endpoint checks if it equals UP string which is the endpoints expected response
    void reportAppIsUp() {
        HealthResponse response = controller.health();
        // status is the parameter for HealthResponse
        assertThat(response.status()).isEqualTo("UP");
    }
}