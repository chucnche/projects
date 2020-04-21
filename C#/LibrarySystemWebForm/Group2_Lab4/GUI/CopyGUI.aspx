<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="CopyGUI.aspx.cs" Inherits="Group2_Lab4.GUI.CopyGUI" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">
        .auto-style1 {
            width: 494px;
        }
        .auto-style2 {
            width: 69px;
        }
        .auto-style4 {
            width: 69px;
            height: 205px;
        }
        .auto-style5 {
            height: 205px;
        }
    .auto-style6 {
        width: 86%;
        height: 337px;
    }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <p style="font-size: large; font-weight: bolder">
        List of Copies
        <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
        <br />
    </p>
    <p>

        Book number:
        <asp:TextBox ID="txtBookNumber" runat="server"></asp:TextBox>
&nbsp; Title:
        <asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>

    </p>
    <p>
        The number of Copies:&nbsp;
        <asp:Label ID="lblNoRows" runat="server"></asp:Label>
    </p>
    <p>
        <table class="auto-style6">
            <tr>
                <td class="auto-style1" rowspan="3">
                    <asp:GridView ID="GridView1" runat="server" Height="248px" Width="483px" AllowPaging="True" DataSourceID="ObjectDataSource1" OnDataBound="GridView1_DataBound" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" DataKeyNames="copyNumber" OnRowDeleted="GridView1_RowDeleted" OnRowUpdated="GridView1_RowUpdated" ForeColor="#000099">
                        <Columns>
                            <asp:CommandField ShowDeleteButton="True" ShowSelectButton="True" />
                        </Columns>
                        <SelectedRowStyle BackColor="Yellow" />
                    </asp:GridView>
                </td>
                <td class="auto-style4">Type<br />
                    <br />
                </td>
                <td class="auto-style5">
                    <asp:TextBox ID="txtType" runat="server"></asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="txtType" ErrorMessage="Type required A or R" ValidationExpression="A|R"></asp:RegularExpressionValidator>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtType" ErrorMessage="Type is not empty"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">Price:</td>
                <td>
                    <asp:TextBox ID="txtPrice" runat="server"></asp:TextBox>
                    <asp:RangeValidator ID="RangeValidator1" runat="server" ControlToValidate="txtPrice" ErrorMessage="From 0 to 999.999.999" MaximumValue="999999999" MinimumValue="0"></asp:RangeValidator>
                    <br />
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="txtPrice" ErrorMessage="Price is not Empty"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </p>
    <p>
        <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DataObjectTypeName="Group2_Lab4.DTL.Copy" DeleteMethod="Delete" InsertMethod="Insert" SelectMethod="GetDataTable" TypeName="Group2_Lab4.DAL.CopyDAO" UpdateMethod="Update" OldValuesParameterFormatString="original_{0}" FilterExpression="bookNumber = {0}">
            <FilterParameters>
                <asp:ControlParameter ControlID="txtBookNumber" Name="n1" PropertyName="Text" />
            </FilterParameters>
        </asp:ObjectDataSource>
        <asp:Button ID="btnAdd" runat="server" Text="Add" Width="75px" OnClick="btnAdd_Click" CausesValidation="False" />
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnEdit" runat="server" Text="Edit" Width="75px" OnClick="btnEdit_Click" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnSave" runat="server" Text="Save" Width="75px" OnClick="btnSave_Click" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnCancel" runat="server" Text="Cancel" OnClick="btnCancel_Click" CausesValidation="False" />
    </p>
    <p>
        &nbsp;</p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
</asp:Content>
