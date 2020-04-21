<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="BorrowerGUI.aspx.cs" Inherits="Group2_Lab4.GUI.BorrowerGUI" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">

    .auto-style6 {
        width: 95%;
        height: 248px;
    }
        .auto-style1 {
            width: 455px;
        }
        .auto-style11 {
            width: 122px;
            height: 27px;
        }
        .auto-style12 {
            width: 299px;
            height: 27px;
        }
        .auto-style13 {
            width: 122px;
            height: 22px;
        }
        .auto-style14 {
            width: 299px;
            height: 22px;
        }
        .auto-style17 {
            width: 122px;
            height: 77px;
        }
        .auto-style18 {
            width: 299px;
            height: 77px;
        }
        .auto-style19 {
            width: 122px;
            height: 50px;
        }
        .auto-style20 {
            width: 299px;
            height: 50px;
        }
        .auto-style21 {
            width: 122px;
            height: 16px;
        }
        .auto-style22 {
            width: 299px;
            height: 16px;
        }
        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <p style="font-size: large; font-weight: bolder">
        List of Members
        <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
    </p>
    <p>
        The number of members:&nbsp;
        <asp:Label ID="lblNumberMembers" runat="server"></asp:Label>
    </p>
        <table class="auto-style6">
            <tr>
                <td class="auto-style1" rowspan="5">
                    <asp:GridView ID="GridView1" runat="server" AllowSorting="True" DataSourceID="ObjectDataSource1" ForeColor="#000099" Height="170px" Width="455px" PageSize="3" DataKeyNames="borrowerNumber" OnDataBound="GridView1_DataBound" OnSelectedIndexChanged="GridView1_SelectedIndexChanged">
                        <Columns>
                            <asp:CommandField ShowDeleteButton="True" ShowSelectButton="True" />
                        </Columns>
                        <SelectedRowStyle BackColor="#FF3300" />
                    </asp:GridView>
                </td>
                <td class="auto-style19">
                    <br />
                    <br />
                    Name</td>
                <td class="auto-style20">
                    &nbsp;<br />
                    <br />
                    <asp:TextBox ID="txtName" runat="server" Width="194px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style11">
                    Sex</td>
                <td class="auto-style12">
                    <asp:TextBox ID="txtSex" runat="server" Width="82px"></asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="txtSex" ErrorMessage="Must F or M" ValidationExpression="F|M"></asp:RegularExpressionValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style13">
                    Address</td>
                <td class="auto-style14">
                    <asp:TextBox ID="txtAddress" runat="server" Width="194px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style21">
                    Telephone</td>
                <td class="auto-style22">
                    <asp:TextBox ID="txtTelephone" runat="server" Width="128px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style17">
                    Email<br />
                    <br />
                    <br />
                </td>
                <td class="auto-style18">
                    <asp:TextBox ID="txtEmail" runat="server" Width="192px" Height="24px"></asp:TextBox>
                    <br />
                    <br />
                    <br />
                </td>
            </tr>
            </table>
    <p>
        <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DataObjectTypeName="Group2_Lab4.DTL.Borrower" DeleteMethod="Delete" InsertMethod="Insert" SelectMethod="GetDataTable" TypeName="Group2_Lab4.DAL.BorrowerDAO" UpdateMethod="Update" OldValuesParameterFormatString="original_{0}">
        </asp:ObjectDataSource>
        <asp:Button ID="btnAdd" runat="server" Text="Add" Width="75px" OnClick="btnAdd_Click" />
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnEdit" runat="server" Text="Edit" Width="75px" OnClick="btnEdit_Click" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnSave" runat="server" Text="Save" Width="75px" OnClick="btnSave_Click" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnCancel" runat="server" Text="Cancel" Height="29px" OnClick="btnCancel_Click" />
        <br />
    </p>
    <p>
    </p>
</asp:Content>
