namespace Entidades
{
    public class clsPersona
    {
        #region Propiedades
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Telefono { get; set; }
        public string Direccion {  get; set; }
        public string Foto { get; set; }
        public DateTime FechaNac {  get; set; }
        public int IDDepartamento { get; set; }
        #endregion

        #region Constructores
        public clsPersona() { }

        public clsPersona(int id, string nombre, string apellidos, string telefono, string direccion, string foto, DateTime fechaNac, int idDepartamento)
        {
            Id = id;
            Nombre = nombre;
            Apellidos = apellidos;
            Telefono = telefono;
            Direccion = direccion;
            Foto = foto;
            FechaNac = fechaNac;
            IDDepartamento = idDepartamento;
        }
        #endregion

    }
}