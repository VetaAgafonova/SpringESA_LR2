<?xml version="1.0" encoding="UTF-8" ?>

<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="ArrayList">
        <h1>
            1Departments
        </h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Leader</th>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="item">
                    <tr>
                        <td><xsl:value-of select="@id"/></td>
                        <td><xsl:value-of select="@title"/></td>
                        <td><xsl:value-of select="@leader"/></td>
                    </tr>
                </xsl:for-each>
            </tbody>
        </table>
    </xsl:template>
</xsl:transform>

