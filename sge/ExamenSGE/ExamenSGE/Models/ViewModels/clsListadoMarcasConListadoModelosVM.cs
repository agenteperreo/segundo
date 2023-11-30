using BL.Listados;
using BL.Manejadoras;
using Entidades;

namespace ExamenSGE.Models.ViewModels
{
    public class clsListadoMarcasConListadoModelosVM
    {
        #region Propiedades
        List<clsModelos> ListadoModelos;
        List<clsMarcas> ListadoMarcas;
        #endregion

        #region Public
        public clsListadoMarcasConListadoModelosVM()
        {
            ListadoModelos = clsListadoModelosBL.listadoCompletoModelosBL();
            ListadoMarcas = clsListadoMarcasBl.listadoCompletoMarcasBL();
        }
        #endregion
    }
}
