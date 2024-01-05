<?xml version="1.0" encoding="UTF-8" ?>

<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="ArrayList">
        <h1>
            1Students
        </h1>
        <table>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>First name</td>
                    <td>Last name</td>
                    <td>Department ID</td>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="item">
                    <tr>
                        <td><xsl:value-of select="id"/></td>
                        <td><xsl:value-of select="firstName"/></td>
                        <td><xsl:value-of select="lastName"/></td>
                        <td><xsl:value-of select="department_id"/></td>
                    </tr>
                </xsl:for-each>
            </tbody>
        </table>
    </xsl:template>
</xsl:transform>



