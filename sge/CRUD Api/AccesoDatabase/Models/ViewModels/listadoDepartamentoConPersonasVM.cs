using BL.Listados;
using DAL;
using Entidades;

namespace AccesoDatabase.Models.ViewModels
{
    public class listadoDepartamentoConPersonasVM : clsPersona
    {
        #region Propiedaes
        public List<clsDepartamento> ListaDepartamentos {  get; set; }
        #endregion

        #region Constructores
        public listadoDepartamentoConPersonasVM() 
        { 
            ListaDepartamentos = clsListaDepartamentosBL.listadoCompletoDepartamentosBL();
        }

        public listadoDepartamentoConPersonasVM(clsPersona persona)
        {
            ListaDepartamentos = clsListaDepartamentosBL.listadoCompletoDepartamentosBL();

            this.Nombre = persona.Nombre;
            this.Apellidos = persona.Apellidos;
            this.Telefono = persona.Telefono;
            this.Direccion = persona.Direccion;
            this.FechaNac = persona.FechaNac;
            this.Id = persona.Id;
            this.IDDepartamento = persona.IDDepartamento;
            this.Foto = persona.Foto;
        }
        #endregion

    }
}
