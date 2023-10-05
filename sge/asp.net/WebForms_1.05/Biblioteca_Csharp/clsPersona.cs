using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Biblioteca_Csharp
{
    internal class clsPersona
    {

        #region Atributos
        private String name;
        #endregion

        #region Constructores
        public clsPersona() { }

        public clsPersona(String name)
        {
            this.name = name;
        }
        #endregion

        #region Propiedades
        public String Name
        { 
            get { return name; } 
            set { name = value; }
        }
        #endregion
    }
}
