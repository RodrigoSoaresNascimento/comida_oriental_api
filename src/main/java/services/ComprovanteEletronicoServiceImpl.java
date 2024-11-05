package services;

import model.ComprovanteEletronico;

public class ComprovanteEletronicoServiceImpl implements ComprovanteEletronicoService{


    @Override
    public void gerarComprovante(ComprovanteEletronico comprovanteEletronico) {
        System.out.println(comprovanteEletronico);
    }
}
