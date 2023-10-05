<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="WebForms_1._05._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <main>
        <section class="row" aria-labelledby="aspnetTitle">

            <h1>Hola Mundo</h1>
            <h5 id="aspnetTitle">
                <asp:TextBox ID="txtNombre" runat="server" Width="1599px" Height="53px"></asp:TextBox>
                <asp:Label ID="lblVacio" runat="server" Text="" ForeColor="Red"></asp:Label>
            </h5>
            <p class="lead">
                <asp:Button ID="btnSaludar" runat="server" Text="Saludar" OnClick="btnSaludar_Click" />
                <asp:Label ID="lblSaludo" runat="server" Text=""></asp:Label>
            </p>
        </section>

        
    </main>

</asp:Content>
