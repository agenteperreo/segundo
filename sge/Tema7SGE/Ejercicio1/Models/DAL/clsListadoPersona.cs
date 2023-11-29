using Ejercicio12y3.Models.Entidades;

namespace Ejercicio12y3.Models.DAL
{
    public class clsListadoPersona
    {
        public static List<clsPersona> listadoCompletoPersonas()
        {
            List<clsPersona> listaPersonas = new List<clsPersona>();
            listaPersonas.Add(new clsPersona("Isaac", "García Carmona", "123456789"));
            listaPersonas.Add(new clsPersona("Alvaro", "Castro Sanchez", "159753684"));
            listaPersonas.Add(new clsPersona("Pedro", "Cornejo Carvajal", "482697153"));
            listaPersonas.Add(new clsPersona("Miguel", "Tontopolla", "456789123"));
            listaPersonas.Add(new clsPersona("Paco", "Calvo", "696969696"));

            return listaPersonas;
        }
    }
}
