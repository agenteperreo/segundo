namespace Tema7SGE.Models.Entidades
{
    public class clsPersona
    {

        #region Propiedades
        public int idPersona { get; set; }
        public String nombre { get; set; }
        public String apellidos { get; set; }
        public String telefono {  get; set; }
        public int idDept { get; set; }
        #endregion

        #region Contructores
        public clsPersona()
        {
            idPersona = 0;
            nombre = "";
            apellidos = "";
            telefono = "";
            idDept = 0;
        }

        public clsPersona(int idPersona, string nombre, string apellidos, string telefono, int idDept)
        {
            this.idPersona = idPersona;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.telefono = telefono;
            this.idDept = idDept;
        }
        #endregion
    }
}
