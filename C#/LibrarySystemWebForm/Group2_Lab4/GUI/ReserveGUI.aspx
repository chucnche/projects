<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ReserveGUI.aspx.cs" Inherits="Group2_Lab4.GUI.ReserveGUI" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">
        .auto-style14 {
            height: 173px;
            position: initial;
            margin-bottom: 0px;
        }


        .auto-style3 {
            width: 475px;
            height: 164px;
        }
        .auto-style13 {
            height: 164px;
        }
        .auto-style15 {
            height: 32px;
            margin-top: 1px;
        }
        .auto-style17 {
            width: 10px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <p style="font-size: large; font-weight: bolder">
        Rerserve a Book
        <asp:Label ID="lblError" runat="server" ForeColor="#990033"></asp:Label>
        <br />
    </p>
    <p>
        Borrower number:&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtBorrowerNumber" runat="server" Width="128px"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name:
        <asp:TextBox ID="txtName" runat="server" Width="126px"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnMember" runat="server" OnClick="btnMember_Click" Text="Check member" Width="200px" />
&nbsp;</p>
    <p>
        Book number:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtBookNumber" runat="server" Width="128px"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Title:&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtTitle" runat="server" Width="122px"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnCondition" runat="server" OnClick="btnCondition_Click" Text="Check condition" Width="196px" />
    </p>

    <div style="margin-left:40px;">
                The number of Reserved books:&nbsp;
        <asp:Label ID="lblNumberReservedBooks" runat="server"></asp:Label>
        <table class="auto-style14">
            <tr>
                <td class="auto-style3">
                    <asp:GridView ID="GridView1" runat="server" Height="93px" PageSize="2" Width="474px">
                    </asp:GridView>
                    <br />
                    <div style="margin-left:30px;">
       Reserved date:&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
        </div>
                    <br />
                    <table style="width:100%;">
            <tr>
                <td class="auto-style17" rowspan="3">
                    <asp:Calendar ID="Calendar1" runat="server" Width="400px" BackColor="White" BorderColor="Black" DayNameFormat="Shortest" Font-Names="Times New Roman" Font-Size="10pt" ForeColor="Black" Height="220px" NextPrevFormat="FullMonth" TitleFormat="Month">
                        <DayHeaderStyle BackColor="#CCCCCC" Font-Bold="True" Font-Size="7pt" ForeColor="#333333" Height="10pt" />
                        <DayStyle Width="14%" />
                        <NextPrevStyle Font-Size="8pt" ForeColor="White" />
                        <OtherMonthDayStyle ForeColor="#999999" />
                        <SelectedDayStyle BackColor="#CC3333" ForeColor="White" />
                        <SelectorStyle BackColor="#CCCCCC" Font-Bold="True" Font-Names="Verdana" Font-Size="8pt" ForeColor="#333333" Width="1%" />
                        <TitleStyle BackColor="Black" Font-Bold="True" Font-Size="13pt" ForeColor="White" Height="14pt" />
                        <TodayDayStyle BackColor="#CCCC99" />
                    </asp:Calendar>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp; &nbsp;<asp:Button ID="btnReserve" runat="server" OnClick="btnReserve_Click" Text="Reserve" Width="154px" />
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
                    <br />
                </td>
                <td class="auto-style13">
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br /></td>
            </tr>
        </table>
    </div>
    <p class="auto-style15">
        &nbsp;</p>
    <p class="auto-style15">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    <p class="auto-style10">
        &nbsp;</p>
</asp:Content>