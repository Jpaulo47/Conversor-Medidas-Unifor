# Conversor de Unidades

Um aplicativo Android moderno e intuitivo para conversão de diferentes unidades de medida de comprimento, desenvolvido em Kotlin seguindo as melhores práticas de desenvolvimento.


## 📱 Funcionalidades

- Conversão entre 11 diferentes unidades de comprimento:
  - Metro
  - Quilômetro
  - Centímetro
  - Milímetro
  - Micrômetro
  - Nanômetro
  - Milha
  - Jarda
  - Pé
  - Polegada
  - Milha náutica
- Interface moderna e intuitiva seguindo os princípios do Material Design
- Splash screen amigável com animações
- Validação de entrada de dados
- Resultados formatados com duas casas decimais
- Suporte para diferentes tamanhos de tela e orientações

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Arquitetura**: MVVM (Model-View-ViewModel)
- **UI**: Material Design Components
- **Binding**: View Binding
- **Animações**: Property Animation
- **Compatibilidade**: SplashScreen API para Android 12+

## 📂 Estrutura do Projeto

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/conversorunidades/
│   │   │   ├── MainActivity.kt           # Tela principal do aplicativo
│   │   │   ├── SplashActivity.kt         # Tela de splash
│   │   │   └── model/
│   │   │       └── ConverterViewModel.kt # Lógica de conversão e tipos de unidades
│   │   ├── res/
│   │   │   ├── drawable/                 # Ícones e recursos gráficos
│   │   │   ├── layout/                   # Layouts XML
│   │   │   │   ├── activity_main.xml     # Layout da tela principal
│   │   │   │   ├── activity_splash.xml   # Layout da tela de splash
│   │   │   │   └── spinner_item.xml      # Layout personalizado para itens do spinner
│   │   │   └── values/                   # Recursos de strings, cores e estilos
│   │   └── AndroidManifest.xml           # Configuração do aplicativo
│   └── build.gradle                      # Configuração de build do módulo
└── build.gradle                          # Configuração de build do projeto
```

## ⚙️ Como Configurar e Executar

### Pré-requisitos

- Android Studio Arctic Fox (2020.3.1) ou superior
- JDK 8 ou superior
- Android SDK 21 ou superior

### Passos para Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Jpaulo47/Conversor-Medidas-Unifor.git
