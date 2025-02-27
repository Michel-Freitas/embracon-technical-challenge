package com.challenge.michelfreitas.challenge.module.zipCode.service;

import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeResponse;
import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeWsResponse;
import com.challenge.michelfreitas.challenge.module.zipCode.model.ZipCodeLog;
import com.challenge.michelfreitas.challenge.module.zipCode.repository.ZipCodeLogRepository;
import com.challenge.michelfreitas.challenge.module.zipCode.service.Impl.ZipCodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ZipCodeServiceTest {

    @Mock
    private IZipCodeWebService zipCodeWebServiceMock;

    @Mock
    private ZipCodeLogRepository zipCodeLogRepositoryMock;

    @InjectMocks
    private ZipCodeService zipCodeServiceMock;

    private ZipCodeWsResponse mockResponse;

    @BeforeEach
    void setUp() {
        mockResponse = new ZipCodeWsResponse(
                "12345-678",
                "Rua Exemplo",
                "",
                "",
                "Bairro Exemplo",
                "Cidade Exemplo",
                "Sigla Estado Exemplo",
                "Estado Exemplo",
                "Região Exemplo",
                "123456",
                "",
                "85",
                "123"
        );
    }

    @Test
    void testGetByZipCode() {
        // Arrange
        when(this.zipCodeWebServiceMock.getZipCodeByCode("12345-678")).thenReturn(this.mockResponse);

        // Act
        ZipCodeResponse response = this.zipCodeServiceMock.getByZipCode("12345-678");

        // Assert
        verify(this.zipCodeWebServiceMock, times(1)).getZipCodeByCode("12345-678");
        verify(this.zipCodeLogRepositoryMock, times(1)).save(any(ZipCodeLog.class));

        assertEquals("12345-678", response.zipCode());
        assertEquals("Rua Exemplo", response.street());
        assertEquals("Bairro Exemplo", response.neighborhood());
        assertEquals("Cidade Exemplo", response.city());
        assertEquals("Sigla Estado Exemplo", response.uf());
    }
}
