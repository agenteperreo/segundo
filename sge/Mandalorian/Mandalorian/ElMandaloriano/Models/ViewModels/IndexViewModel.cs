using Biblioteca;

namespace ElMandaloriano.Models.ViewModels
{
    public class IndexViewModel
    {

        #region Atributos
        public clsMision Mision { get; set; }
        public List<clsMision> ListaMisiones { get; set; }
        #endregion
        #region Constructores
        public IndexViewModel() { }
        public IndexViewModel(clsMision mision, List<clsMision> listaMisiones)
        {
            Mision = mision;
            ListaMisiones = listaMisiones;
        }
        #endregion
    }
}

