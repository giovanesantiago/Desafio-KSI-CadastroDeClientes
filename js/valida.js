
function abrirTermo() {
    alert(" Voce realmente ler os termos ? ")
}

function validaNome(value) {
    const temNumero = value.search(RegExp('[0-9]')) > -1
    const temCaract = value.search(RegExp('[.!@#$%^&*()-+]')) > -1

    if(temNumero || temCaract) {
        document.getElementById("invalid-nome").innerHTML = 'Nome invalido'
    }else {
        document.getElementById("invalid-nome").innerHTML = ''
    }

}

function validaCpf(value) {
    const cpf = value.replace(/[^0-9]/g, '')
    
   function TestaCPF(strCPF) { //teste de validação da receita
        var Soma;
        var Resto;
        Soma = 0;
      if (strCPF == "00000000000") return false;
    
      for (let i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
      Resto = (Soma * 10) % 11;
    
        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        if (Resto != parseInt(strCPF.substring(9, 10)) ) return false;
    
      Soma = 0;
        for (let i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
        Resto = (Soma * 10) % 11;
    
        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false;
        return true;
    }
    const cpfvalidoreceita = TestaCPF(cpf) 
    // condiçoes
    
    if(!cpfvalidoreceita){
        document.getElementById("invalid-cpf").innerHTML = 'CPF invalido'
    }else {
        const cpfValido = cpf.replace(/^([\d]{3})([\d]{3})([\d]{3})([\d]{2})$/, "$1.$2.$3-$4")
        document.getElementById("cpf").value = cpfValido
        document.getElementById("invalid-cpf").innerHTML = ''
    }
}