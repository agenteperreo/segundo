using DAL;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CRUD_Maui.ViewModels
{
    public class departamentoPorIdVM : clsPersona
    {
        #region Atributos
        private string nombreDepartamento;
        #endregion

        #region Constructores
        public departamentoPorIdVM() 
        {
            nombreDepartamento = clsNombreDepartamentoPorIdDAL.nombreDepPorIdDAL(IDDepartamento);
        }
        #endregion

        #region Propiedades
        public string NombreDepartamento
        {
            get { return nombreDepartamento; }
        }
        #endregion
    }
}
