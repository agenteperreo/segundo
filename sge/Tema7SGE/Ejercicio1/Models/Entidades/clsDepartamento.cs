namespace Ejercicio12y3.Models.Entidades
{
    public class clsDepartamento
    {
        #region Propiedades
        public int Id { get; set; }
        public string Nombre { get; set;}
        #endregion

        #region Constructores
        public clsDepartamento() { }

        public clsDepartamento(int id, string nombre) { 
            Id = id;
            Nombre = nombre;
        }
        #endregion
    }
}
