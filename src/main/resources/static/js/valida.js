// Validação JS so para intereção com usuario não esta evitando o envio deixei essa validação no back-end


// Desabilitar botão de cadastrar enquanto não aceitou os termos
function buttonOnOff(estado) {
    console.log(estado)
    if(!estado) {
        document.getElementById("btn-cadastro").disabled = true;
    } else {
        document.getElementById("btn-cadastro").disabled = false;
    }
}


// Como não tem termo deixei essa BRincadeira caso alguem tente ler 
function abrirTermo() {
    alert(" Voce realmente ler os termos ? ")
}



function validaNome(value) {
    const temNumero = value.search(RegExp('[0-9]')) > -1 // Verificando numero
    const temCaract = value.search(RegExp('[.!@#$%^&*()-+]')) > -1 // Verificando caractere

    if(temNumero || temCaract) { // se tem numero ou caractere renderiza mensagem de nome invalido 
        document.getElementById("invalid-nome").innerHTML = 'Nome invalido'
        return false
    }else { // Se não tem deixa paragrafo vazio 
        document.getElementById("invalid-nome").innerHTML = ''
        return true;
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

function validaNasc(value) {
    const data = value
    console.log(data)
    const ano = parseInt(data.slice(0, 4)) 
    const dataAtual = new Date() // pegando data atual para tirar idade
    const anoAtual = dataAtual.getFullYear()
 
    // Validação de idade so para evitar data de nascimento maluca
    if(anoAtual - ano < 10) { // menor 10 anos não passa
        document.getElementById("invalid-nasc").innerHTML = 'Nascimento invalido'
    }else if (anoAtual - ano > 100) { // maior que 100 tambem não passa 
        document.getElementById("invalid-nasc").innerHTML = 'Nascimento invalido'
    }else {
        document.getElementById("invalid-nasc").innerHTML = ''
    }
}



