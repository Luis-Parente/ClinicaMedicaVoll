package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.TokenExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler.dto.ErroCustomizadoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExcecaoHandler {

    @ExceptionHandler(EntidadeNaoEncontradoExcecao.class)
    public ResponseEntity<ErroCustomizadoDTO> entidadeNaoEncontrada(EntidadeNaoEncontradoExcecao e,
                                                                    HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizadoDTO err = new ErroCustomizadoDTO(Instant.now(), status.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CampoInvalidoExcecao.class)
    public ResponseEntity<ErroCustomizadoDTO> campoInvalidoExcecao(CampoInvalidoExcecao e,
                                                                   HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErroCustomizadoDTO err = new ErroCustomizadoDTO(Instant.now(), status.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroCustomizadoDTO> illegalArgumentException(IllegalArgumentException e,
                                                                       HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ErroCustomizadoDTO err = new ErroCustomizadoDTO(Instant.now(), status.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(TokenExcecao.class)
    public ResponseEntity<ErroCustomizadoDTO> token(TokenExcecao e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroCustomizadoDTO err = new ErroCustomizadoDTO(Instant.now(), status.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
