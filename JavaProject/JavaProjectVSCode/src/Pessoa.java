public class Pessoa {
        String nome;
        int idade;

        void crianca_adolescente_adulto (int idade, String nome)
        {
            if (idade <= 12)
            {
                System.out.println(nome + " é criança!");
            }

            else if (idade >= 13 && idade < 18)
            {
                System.out.println(nome + " é adolescente!");
            }

            else if (idade >= 13 && idade < 18)
            {
                System.out.println(nome + " é adolescente!");
            }

            else if (idade >= 18)
            {
                System.out.println(nome + " é adulto!");
            }
        }
}

