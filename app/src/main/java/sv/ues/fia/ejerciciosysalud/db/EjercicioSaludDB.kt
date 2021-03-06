package sv.ues.fia.ejerciciosysalud.db

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
        entities = [
            DietaEntity::class,
            EjercicioEntity::class,
            EstadoSaludEntity::class,
            PlanEntity::class,
            UsuarioEntity::class,

        ],
        version = 1,
        exportSchema = false
)
abstract class EjercicioSaludDB : RoomDatabase() {
    abstract fun DietaDao(): DietaDao
    abstract fun EjercicioDao(): EjercicioDao
    abstract fun EstadoSaludDao(): EstadoSaludDao
    abstract fun PlanDao(): PlanDao
    abstract fun UsuarioDao(): UsuarioDao


    private class EjerciciosDBCallback(
            private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database)
                }
            }
        }

        suspend fun populateDatabase(db: EjercicioSaludDB) {
            // Limpiar base
            db.EstadoSaludDao().deleteAll()
            db.EjercicioDao().deleteAll()
            db.DietaDao().deleteAll()
            db.PlanDao().deleteAll()
            db.UsuarioDao().deleteAll()
            val DI_IDieta = listOf("DIEDEL1", "DIEDEL2", "DIEDEL3", "DIEDEL4", "DIEDEL5", "DIEDEL6", "DIEDEL7", "DIEDEL8", "DIEDEL9", "DIEDEL10", "DIEDEL12", "DIEDEL13"
                , "DIESAL1", "DIESAL2", "DIESAL3", "DIESAL4", "DIESAL5", "DIESAL6", "DIESAL7", "DIESAL8", "DIESAL9", "DIESAL10", "DIESAL11", "DIESAL12", "DIESAL13"
                , "DIESOB1", "DIESOB2", "DIESOB3", "DIESOB4", "DIESOB5", "DIESOB6", "DIESOB7", "DIESOB8", "DIESOB9", "DIESOB10", "DIESOB11", "DIESOB12", "DIESOB13")
            val DI_Tiempo = listOf("Desayuno", "Merienda", "Todos", "Almuerzo", "Merienda", "Todos", "Desayuno", "Merienda", "Cena", "Merienda", "Merienda", "Desayuno", "Merienda"
                , "Almuerzo", "Almuerzo", "Desayuno", "Todos", "Todos", "Todos", "Cena", "Todos", "Todos", "Todos", "Todos", "Desayuno", "Desayuno",
                "Desayuno", "Cena", "Todos", "Todos", "Todos", "Cena", "Todos", "Desayuno", "Todos", "Almuerzo", "Almuerzo", "Todos", "Todos")
            val DI_Alimentos = listOf("L??cteos enteros", "Batidos de prote??nas", " Arrozes y legumbres", "Carnes rojas",
                    "Nueces y mantequilla de nueces", "Pan integral", "Cerales, papas y otros alimentos con almidon", "Suplementos prote??nicos", "Mariscos", "Frutas deshidratadas", "Chocolate oscuro", "Huevos ", "Fruta y verdura", "Mariscos", "Carnes magras", "Huevos ", "Productos de soya", "Nueces y mantequilla de nueces", "Lacteos bajos en grasa", "Pastas", "Guisos y tortillas ", "Verduras", "Arrozes y legumbres", "Pan integral", "Cerales, papas  y otros alimentos con almidon", "L??cteos bajos en grasa", "Huevos", "Atun ", "Frutas", "Verduras", "Productos de soya", "Alimentos de fibra ", "Pan integral", "Cerales integrales, papas  y otros alimentos con almidon", "Frutos secos", "Carne magra", "Pechuga de pollo", "Avena")
            val PLAN_ID_Plan = listOf("P_PRIN", "P_INTER", "P_AVAN")
            val PLAN_Dificultad = listOf("Principiante", "Intermedio", "Avanzado")
            val PLAN_TiempoAprox = listOf("5 - 10 min", "10 - 20 min", "20 -30 min")
            val PLAN_Kcal = listOf(1900f, 3375f, 4875f)
            val EJER_IDejer = listOf("ac1", "ac2", "ac3", "ac4", "ac5", "ac6", "ac7", "ac8", "ac9", "ac10", "ac11", "ac12", "ac13", "ac14", "ac15", "ac16", "ac17", "ac18", "ac19", "ac20", "ac21", "ac22")
            val EJER_NombreEjer = listOf("Burpess", "Sentadillas", "Elevaci??n de piernas recogidas", "Elevaci??n lateral", "Empuje de abdomen ", "Plancha y posici??n de rana", "Sentadilla con balanceo", "Abdominal en V", "Elevaci??n de piernas", "Trotar", "Plancha amplia con elevaci??n de brazo", "Elevaci??n de rodilla", "Reverencia", "Reverencia con elevaci??n de pierna ", "Toque de pie", "Flexiones de brazos", "Saltos de tijera", "Saltos cruzados", "Zancadas laterales", "Zancada y patada", "Zancada derecha/izquierda", "Plancha b??sica")
            val EJER_Indicaciones = listOf("Comienza de pie. Baja y manten la posicion de sentadilla y \n" +
                    "pon las manos en el suelo.Estira las piernas y los brazos a la vez. \n" +
                    "Vuelve de inmediato a la posici??n de sentadilla. Salta desde la \n" +
                    "posici??n de sentadilla.\n" +
                    "Ejercicio  aer??bico y de fuerza.\n", "Con las piernas separadas a la altura de los hombros, bajar y subir.\n" +
                    "flexionando las rodillas.", "Tumbate boca arriba y levantar las piernas encogiendo las rodillas,\n" +
                    " haciendo un movimiento de izquierda a derecha y viceversa.\n" +
                    "Este ejercicio trabaja los adnominales.\n", "De pie, subimos una de las rodillasy acompan??amos el movimiento \n" +
                    "con el brazo hasta que brazo y rodilla se toquen. \n" +
                    "Trabajamos core, cua??driceps, glu??teos.\n", "Tumbate boca arriba, apoyando los codos al suelo y levantar las \n" +
                    "piernas levemente, hacer presi??n moviendo las piernas hacia el\n" +
                    "pecho y viceversa. Ester ejercicio trabaja los abdominales.\n", "Comienza en posici??n para hacer plancha con codos, \n" +
                    "seguidamente recoge las piernas adopta la posici??n \n" +
                    "de sentadilla. Este ejercicio trabaja el abdomen y las piernas.\n", "Mantente erguido, con los pies un poco m??s separados que \n" +
                    "al ancho de las cadera y ligeramente abiertos. Ag??chate y coloca \n" +
                    "las manos en el suelo entre las piernas, manteniendo el pecho \n" +
                    "y la barbilla hacia arriba. Salta con las piernas dobladas, lanzando\n" +
                    " los brazos al aire en lo alto del salto. Baja los brazos mientras aterrizas\n" +
                    " en la posici??n de sentadilla.\n", "Tumbate boca arriba con las piernas y los brazos extendidos, y las \n" +
                    "piernas juntas. Levanta el tronco y las piernas, vuelve a la posici??n\n" +
                    " original y repite el ejercicio.\n", "Tumbate boca arriba y coloca tus manos debajo de las caderas en\n" +
                    " modo de apoyo. Luego eleva las piernas rectas hasta formar un\n" +
                    "??ngulo recto con el suelo. Baja las piernas despacio y vuelve repetir.\n", "Ponte de pie con los pies separados el ancho de tus caderas y los \n" +
                    "brazos colgando libremente a los lados. Mant??n la barbilla paralela \n" +
                    "al suelo y la curva natural de la parte inferior de tu espalda.\n" +
                    "Tensa el tronco. Impulsa explosivamente tu rodilla izquierda hacia \n" +
                    "el techo a la vez que balanceas el brazo derecho hacia delante y el \n" +
                    "codo izquierdo hacia atr??s. Sigue corriendo en el lugar con un ritmo\n" +
                    "moderado durante el tiempo determinado.\n", "Ub??quese boca abajo con los codos y los dedos de los pies apoyados\n" +
                    " sobre el suelo. El cuerpo debe formar una l??nea recta desde los hombros\n" +
                    "hasta los tobillos. Contraiga los abdominales y los gl??teos y separe los\n" +
                    " pies a una distancia mayor que la separaci??n de los hombros.\n" +
                    "Despegue un brazo. Mantenga esa posici??n y vuelva a la posici??n\n" +
                    "inicial, repita alternando lados.\n", "Coloquese de pie con los pies a la anchura de los hombros. Dobla la rodilla \n" +
                    "y la cadera derechas al mismo tiempo para levantar la rodilla hacia el pecho\n" +
                    " mientras mueves el codo izquierdo hacia adelante y el codo derecho hacia atr??s.\n" +
                    "Cambie la posici??n de sus piernas, extienda la pierna derecha y doble la pierna \n" +
                    "izquierda mientras cambia la posici??n de sus brazos. Vaya alternando el pie que\n" +
                    " se coloca en el suelo durante el tiempo requerido.\n", "Coloquese de pie, con las manos en el cuello y los codos hacia arriba y con las \n" +
                    "piernas juntas, manteniedo esa posici??n inclinese hacia adelante lo maximo \n" +
                    "que pueda, volver a la posici??n inicial y repetir el ejercicio con la parte izquierda.\n", "Coloquese de pie, dobla la rodilla y la cadera derechas al mismo tiempo para \n" +
                    "levantar la pierna hacia atr??s 90?? grados, mientras mueves el pecho hacia adelante\n" +
                    " y los brazos extendidos a los lados, volver a la posici??n inicial y repetir el ejercicio\n" +
                    " con la parte izquierda.\n", "Coloquese de pie y con las piernas separadas a la distancia de los hombros, \n" +
                    "mueva el brazo izquierdo tratando de tocar el pie opuesto a su brazo, vuelva \n" +
                    "a la posici??n inicial y realice la acci??n con el otro brazo.\n", "T??mbate boca abajo en el suelo, extiende los brazos  y apoya las manos un\n" +
                    " poco m??s separadas que la anchura de los hombros. El cuerpo debe trazar \n" +
                    "una l??nea recta desde  los tobillos a la cabeza. Recuerda tensar los gl??teos y los\n" +
                    " abdominales durante todo el movimiento. Deja que el cuerpo descienda hasta que el\n" +
                    " pecho casi toque el suelo (sin llegar a tocarlo). Haz una pausa con el cuerpo abajo y \n" +
                    "luego imp??lsate para volver a la posici??n inicial lo antes posible. Mant??n la alineaci??n \n" +
                    "del cuerpo en todo momento.\n", "Ponte de pie con las piernas juntas y los brazos a ambos lados. Dobla ligeramente \n" +
                    "las rodillas y salta al aire. Al saltar, separa las piernas para separarte del ancho \n" +
                    "de los hombros, y estira los brazos sobre la cabeza. Vuelve a la posici??n inicial.\n", "Ponte de pie, da un salto moviendo la pierna izquierda hacia delante y el brazo \n" +
                    "opuesto hacia atr??s, repite esto con la pierna derecha.\n", "Dar una zancada hacia el lado con la pierna derecha, dejando esta\n" +
                    " flexionada y la otra pierna estirada. Hacer lo mismo con la pierna \n" +
                    "izquierda, repita alternando lados.\n", "Dar una zancada hacia atr??s con la pierna derecha y bajar la rodilla \n" +
                    "sin que llegue a tocar el suelo. Hacer lo mismo con la pierna izquierda,\n" +
                    " repita alternando lados..\n", "Dar una zancada hacia atr??s con la pierna derecha y bajar la rodilla \n" +
                    "sin que llegue a tocar el suelo. Hacer lo mismo con la pierna izquierda,\n" +
                    " repita alternando lados.\n", "Dar una zancada hacia atr??s con la pierna derecha para uego levantarse y \n" +
                    "realizar una patada con la misma pierna. Hacer lo mismo con la pierna\n" +
                    "izquierda, repita alternando lados.\n", "Comienza en posici??n para hacer flexiones y manten los brazos estirados, \n" +
                    "de esta forma se fortalece el abdomen y los musculos de la espalda.\n")
            val USU_IDieta = "DIESAL1"
            val USU_ID_Plan = "P_PRIN"
            val USU_IDEstado = 1
            val ES_TotalDias = 0
            val ES_Peso = 70f
            val ES_Altura = 180f
            val ES_IMC = 21.6f




            for (i in 0..2) {
                db.PlanDao().insert(
                        PlanEntity(
                                PLAN_ID_Plan[i],
                                PLAN_Dificultad[i],
                                PLAN_TiempoAprox[i],
                                PLAN_Kcal[i]
                        )
                )
            }
            for (i in 0..21) {
                db.EjercicioDao().insert(
                        EjercicioEntity(
                                EJER_IDejer[i],
                                EJER_NombreEjer[i],
                                EJER_Indicaciones[i]
                        )
                )
            }
            for (i in 0..38) {
                db.DietaDao().insert(
                        DietaEntity(
                                DI_IDieta[i],
                                DI_Tiempo[i],
                                DI_Alimentos[i]
                        )
                )
            }
            db.EstadoSaludDao().insert(EstadoSaludEntity(ID_Estado = USU_IDEstado,TotalDias =  ES_TotalDias,Peso =  ES_Peso,Altura =ES_Altura, IMC= ES_IMC))
            db.UsuarioDao().insert(UsuarioEntity(USU_IDieta, USU_ID_Plan, USU_IDEstado))
        }

    }

    companion object {
        @Volatile
        private var INSTANCE: EjercicioSaludDB? = null
        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ):  EjercicioSaludDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        EjercicioSaludDB::class.java,
                        "registro_ejercicios_db_new"
                ).addCallback(EjerciciosDBCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }

}