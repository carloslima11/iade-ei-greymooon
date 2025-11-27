package com.gamestore.controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gamestore.model.Game
import com.gamestore.model.ItemCompravel
import com.gamestore.ui.theme.GameStoreTheme
import kotlin.jvm.java
import android.content.Intent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameStoreTheme {
                //itens Solo Leveling
                val SoloLevelingItem1 = ItemCompravel(
                    iditens = 1,
                    nomeitens = "Demon King Sword",
                    descricaoitens = "Forjada nas profundezas do Abismo, esta espada pertenceu a um tirano que tentou conquistar o mundo. Ela sussurra ambições sombrias ao seu portador, trocando sanidade por poder bruto",
                    precoitens = 29.99,
                    imagemitens = com.gamestore.R.drawable.demonking_sword
                )

                val SoloLevelingItem2 = ItemCompravel(
                    iditens = 2,
                    nomeitens = "Knights Killer",
                    descricaoitens = "Desprezada pela Guarda Real, esta arma rudimentar foi inventada por rebeldes para nivelar o jogo contra cavaleiros blindados. Ela encontra brechas até no aço mais resistente.",
                    precoitens = 19.99,
                    imagemitens = com.gamestore.R.drawable.knights_killer
                )

                val SoloLevelingItem3 = ItemCompravel(
                    iditens = 3,
                    nomeitens = "The Sword of Light",
                    descricaoitens = "Dizem ser um presente dos céus para o Primeiro Herói. A lâmina nunca perde o fio e irradia um calor que bane as sombras e aterroriza os mortos-vivos.",
                    precoitens = 29.99,
                    imagemitens = com.gamestore.R.drawable.sword_of_light
                )

                val SoloLevelingItem4 = ItemCompravel(
                    iditens = 4,
                    nomeitens = "Fénix Bow",
                    descricaoitens = "Encordoado com a veia de um pássaro de fogo mítico e esculpido em madeira de freixo chamuscada. Não requer pederneira; o espírito de luta do usuário alimenta as chamas.",
                    precoitens = 21.99,
                    imagemitens = com.gamestore.R.drawable.fenix_bow
                )

                val SoloLevelingItem5 = ItemCompravel(
                    iditens = 5,
                    nomeitens = "Heavenly Spear",
                    descricaoitens = "Caiu dos céus durante a Guerra dos Deuses. É leve como uma pena para os justos, mas impossivelmente pesada para os perversos.",
                    precoitens = 27.99,
                    imagemitens = com.gamestore.R.drawable.heavenly_spear
                )

                val SoloLevelingItem6 = ItemCompravel(
                    iditens = 6,
                    nomeitens = "Lizard Glave",
                    descricaoitens = "Criada pelas tribos reptilianas do Grande Pântano. A lâmina é feita da presa afiada de um dragão do pântano e é permanentemente revestida com uma toxina natural paralisante.",
                    precoitens = 38.99,
                    imagemitens = com.gamestore.R.drawable.lizard_glave
                )

                val SoloLevelingItem7 = ItemCompravel(
                    iditens = 7,
                    nomeitens = "Zeke's Fragment",
                    descricaoitens = "Zeke foi o maior lanceiro da história até que sua arma se partiu contra uma montanha. Este fragmento, embora quebrado, ainda retém a força fantasma de seu mestre original.",
                    precoitens = 14.99,
                    imagemitens = com.gamestore.R.drawable.zekes_fragment
                )



                //itens Hades II
                val Hades2item1 = ItemCompravel(
                    iditens = 1,
                    nomeitens = "Nectar",
                    descricaoitens = "Uma garrafa de ambrosia líquida destilada nos pomares do Elísio. Oferecer isso a alguém não é apenas um presente, é um convite para um laço eterno. Dizem que o sabor muda para refletir o que o bebedor mais deseja.",
                    precoitens = 14.99,
                    imagemitens = com.gamestore.R.drawable.nectar
                )

                val Hades2Item2 = ItemCompravel(
                    iditens = 2,
                    nomeitens = "Hades II Original SoundTrack",
                    descricaoitens = "Uma coleção de hinos compostos para a Princesa do Submundo. Das baladas melancólicas às guitarras frenéticas de batalha, estas músicas carregam a essência da feitiçaria e da escuridão.",
                    precoitens = 14.99,
                    imagemitens = com.gamestore.R.drawable.hadessoundtrack
                )

                val Hades2Item3 = ItemCompravel(
                    iditens = 3,
                    nomeitens = "Hades + Hades 2 Bundle",
                    descricaoitens = "Testemunhe a jornada de Zagreus para escapar do inferno e a cruzada de Melinoë para retomá-lo. Duas gerações, dois estilos de combate, uma história lendária que desafia o próprio Tempo.",
                    precoitens = 65.68,
                    imagemitens = com.gamestore.R.drawable.bundle
                )

                val Hades2Item4 = ItemCompravel(
                    iditens = 4,
                    nomeitens = "Druida's Staff",
                    descricaoitens = "Colhido da Árvore Mãe sem o uso de ferramentas de ferro. O cajado ainda está vivo; suas folhas nunca murcham e ele canaliza a fúria da natureza para prender inimigos em raízes espinhosas",
                    precoitens = 27.68,
                    imagemitens = com.gamestore.R.drawable.druids_staff
                )

                val Hades2Item5 = ItemCompravel(
                    iditens = 5,
                    nomeitens = "Infernal Arms",
                    descricaoitens = "Escurecido pelas cinzas de mil batalhas demoníacas. Este escudo não serve apenas para proteção; ele possui uma boca demoníaca esculpida na frente que morde qualquer um tolo o suficiente para atacar de perto.",
                    precoitens = 35.68,
                    imagemitens = com.gamestore.R.drawable.infernal_arms
                )

                val Hades2Item6 = ItemCompravel(
                    iditens = 6,
                    nomeitens = "Horizon Bow",
                    descricaoitens = "Um artefato que conecta os três reinos materiais. O arco muda de cor conforme a postura do arqueiro: azul para flechas fluidas como a água, marrom para impactos pesados como a rocha, e branco para disparos velozes como o vento.",
                    precoitens = 23.68,
                    imagemitens = com.gamestore.R.drawable.elemental_bow
                )

                val Hades2Item7 = ItemCompravel(
                    iditens = 7,
                    nomeitens = "Witch's Staff",
                    descricaoitens = "Um canalizador simples, mas volátil, para magia arcana. A madeira parece sussurrar feitiços antigos quando a lua está cheia, amplificando o poder de maldições e feitiços de controle.",
                    precoitens = 12.68,
                    imagemitens = com.gamestore.R.drawable.witchs_staff
                )



                //itens GOW II
                val GOW2Item1 = ItemCompravel(
                    iditens = 1,
                    nomeitens = "Chaos Blades",
                    descricaoitens = "Alimentadas por uma raiva primordial e forjadas no fogo do submundo. As correntes permitem que o usuário ataque a média distância, criando um turbilhão incontrolável de aço quente e destruição.",
                    precoitens = 29.99,
                    imagemitens = com.gamestore.R.drawable.chaos_blades
                )

                val GOW2Item2 = ItemCompravel(
                    iditens = 2,
                    nomeitens = "Barbarian Hammer",
                    descricaoitens = "Sem magia, sem elegância e sem piedade. Apenas peso esmagador capaz de transformar armaduras de placas em sucata retorcida e ossos em pó. Exige força sobre-humana para ser erguido.",
                    precoitens = 9.99,
                    imagemitens = com.gamestore.R.drawable.barbarian_hammer
                )

                val GOW2Item3 = ItemCompravel(
                    iditens = 3,
                    nomeitens = "Destiny Spear",
                    descricaoitens = "Dizem que, uma vez arremessada, esta arma não para até provar o sangue de seu objetivo. Ela ignora evasivas e escudos mágicos, pois o fim da batalha já foi escrito nas estrelas.",
                    precoitens = 19.68,
                    imagemitens = com.gamestore.R.drawable.destiny_spear
                )

                val GOW2Item4 = ItemCompravel(
                    iditens = 4,
                    nomeitens = "Nemesis Whip",
                    descricaoitens = "Imbuído com o espírito da Deusa da Vingança. Esta arma não fere apenas a carne, mas julga a alma. Quanto mais \"pecados\" ou dano o inimigo causou, mais devastador será o impacto do chicote.",
                    precoitens = 19.68,
                    imagemitens = com.gamestore.R.drawable.nemesis_whip
                )

                val GOW2Item5 = ItemCompravel(
                    iditens = 5,
                    nomeitens = "Olympus Divine Sword",
                    descricaoitens = "Forjada por Hefesto para um campeão escolhido. O metal vibra com uma pureza celestial que nenhum mortal corrupto consegue segurar sem se queimar. Ela brilha mais forte na presença de monstros mitológicos.",
                    precoitens = 24.68,
                    imagemitens = com.gamestore.R.drawable.olympus_divine_sword
                )



                //card do primeiro jogo
                val SoloLeveling = Game(
                    idgame = 1,
                    nomegame = "Solo Leveling",
                    descricaogame = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações em todo o mundo, agora é um jogo de RPG de ação! Ajude nosso herói a crescer a partir de seu humilde começo E-Rank.",
                    precogame = 59.99,
                    imagegame = com.gamestore.R.drawable.solo_leveling,
                    itens = listOf(SoloLevelingItem1, SoloLevelingItem2, SoloLevelingItem3, SoloLevelingItem4, SoloLevelingItem5, SoloLevelingItem6, SoloLevelingItem7)
                )

                //card do segundo jogo
                val Hades2 = Game(
                    idgame = 2,
                    nomegame = "Hades II",
                    descricaogame = "Lute além do Submundo usando feitiçaria negra para enfrentar o Titã do Tempo nesta sequência encantadora do premiado rastreador de masmorras rogue-like.",
                    precogame = 29.99,
                    imagegame = com.gamestore.R.drawable.hades2,
                    itens = listOf(Hades2item1, Hades2Item2, Hades2Item3, Hades2Item4, Hades2Item5, Hades2Item6, Hades2Item7)
                )

                //card do terceiro jogo
                val GOW2 = Game(
                    idgame = 1,
                    nomegame = "God Of War II",
                    descricaogame = "Sentado em cima de seu trono no Olimpo, Kratos, o guerreiro mortal uma vez tornou-se uma ameaça muito pior do que seu antecessor, Ares, já havia sido. Kratos é um Deus cruel, cuja ira ataca por qualquer um que cruza seu caminho ou o caminho de seu amado Esparta.",
                    precogame = 79.99,
                    imagegame = com.gamestore.R.drawable.gow_cover,
                    itens = listOf(GOW2Item1, GOW2Item2, GOW2Item3, GOW2Item4, GOW2Item5)
                )

                //lista dos jogos
                val listadejogos = listOf(SoloLeveling, Hades2, GOW2)

                // chama o view(main screen)
                com.gamestore.view.screens.MainScreen(
                    games = listadejogos,
                    onGameClick = { game ->
                        // lógica de navegação (controller)
                        val intent = Intent(this@MainActivity, com.gamestore.controller.GameDetailActivity::class.java)

                        // preparar para transporta o "objeto"
                        intent.putExtra("game_data", game)

                        // iniciar a viagem
                        startActivity(intent)
                    }
                )

            }
        }
    }
}
