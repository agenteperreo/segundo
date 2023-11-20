using Biblioteca;

namespace ElMandaloriano.Models.DAL
{
    public class obtenerMision
    {

        /// <summary>
        /// Método que devuelve una misión específica de la lista identificada por el Id.
        /// Precondición: id debe ser mayor que 0
        /// Postcondiciones: el objeto devuelto puede ser null o una misión rellan si se encuentra.
        /// </summary>
        /// <param name="Id">int</param>
        /// <returns>devuelve uns clsMision</returns>
        public static clsMision obtenerMisionId(int Id)
        {
            List<clsMision> listaMisiones = clsListaMisiones.getListaCompletaMisiones();
            return listaMisiones.Find(x => x.Id == Id);
        }
    }
}
