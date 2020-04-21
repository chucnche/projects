<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="BookGUI.aspx.cs" Inherits="Group2_Lab4.GUI.BookGUI" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">

        .auto-style2 {
            width: 100%;
            height: 340px;
        }
        .auto-style3 {
            width: 475px;
        }
        .auto-style7 {
            height: 110px;
            width: 46px;
        }
        .auto-style6 {
            height: 110px;
        }
        .auto-style8 {
            height: 130px;
            width: 46px;
        }
        .auto-style5 {
            height: 130px;
        }
        .auto-style9 {
            height: 111px;
            width: 46px;
        }
        .auto-style4 {
            height: 111px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <p style="font-size: large; font-weight: bolder">
        List of Books
        <asp:Label ID="lblError" runat="server" ForeColor="#990033"></asp:Label>
        <br />
    </p>
    <p>
        Title:&nbsp;&nbsp;
        <asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnFilter" runat="server" OnClick="btnFilter_Click" Text="Filter" Width="70px" />
        </p>
    <p>
        The number of Books:&nbsp;
        <asp:Label ID="lblNoRows" runat="server"></asp:Label>
    </p>
    <div style="margin-left:40px;">
        <table class="auto-style2">
            <tr>
                <td class="auto-style3" rowspan="3">
                    &nbsp;
                    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True" DataSourceID="ObjectDataSource1" ForeColor="#3333CC" Height="188px" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" Width="466px" OnDataBound="GridView1_DataBound" DataKeyNames="bookNumber" OnRowDeleted="GridView1_RowDeleted" OnRowUpdated="GridView1_RowUpdated">
                        <Columns>
                            <asp:CommandField ShowDeleteButton="True" ShowSelectButton="True" />
                        </Columns>
                        <SelectedRowStyle BackColor="#FF3300" />
                    </asp:GridView>
                </td>
                <td class="auto-style7"></td>
                <td class="auto-style6"></td>
            </tr>
            <tr>
                <td class="auto-style8">Title<br />
                    <br />
                    <br />
                    <br />
                    Authors</td>
                <td class="auto-style5">
                    <asp:TextBox ID="txtTitle1" runat="server"></asp:TextBox>
                    <br />
                    <br />
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtTitle1" ErrorMessage="Title can not be empty!" Enabled="False"></asp:RequiredFieldValidator>
                    <br />
                    <br />
                    <asp:TextBox ID="txtAuthors" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style9">Publisher</td>
                <td class="auto-style4">
                    <asp:TextBox ID="txtPublisher" runat="server"></asp:TextBox>
                </td>
            </tr>
        </table>
    </div>
    <p class="auto-style10">
        <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="Add" Width="73px" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnEdit" runat="server" OnClick="btnEdit_Click" Text="Edit" Width="75px" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:Button ID="btnCopies" runat="server" OnClick="btnCopies_Click" Text="Copies" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnSave" runat="server" OnClick="btnSave_Click" Text="Save" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnCancel" runat="server" OnClick="btnCancel_Click" Text="Cancel" />
    </p>
        <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" SelectMethod="GetDataTable" TypeName="Group2_Lab4.DAL.BookDAO" OldValuesParameterFormatString="original_{0}" DataObjectTypeName="Group2_Lab4.DTL.Book" DeleteMethod="Delete" InsertMethod="Insert" UpdateMethod="Update">
            <FilterParameters>
                <asp:ControlParameter ControlID="txtTitle"  Name="title" PropertyName="Text" />
            </FilterParameters>
            
    </asp:ObjectDataSource>
    <p>
    </p>

</asp:Content>
