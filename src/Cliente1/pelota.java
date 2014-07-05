/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente1;

/**
 *
 * @author KatherinC
 */
public class pelota {
    public Integer xIniPelota,yIniPelota,zIniPelota,xFinPelota,yFinPelota,zFinPelota;
    public double velPelota, angPelota;

    public pelota(Integer xIniPelota, Integer yIniPelota, Integer zIniPelota, Integer xFinPelota, Integer yFinPelota, Integer zFinPelota, double velPelota, double angPelota) {
        this.xIniPelota = xIniPelota;
        this.yIniPelota = yIniPelota;
        this.zIniPelota = zIniPelota;
        this.xFinPelota = xFinPelota;
        this.yFinPelota = yFinPelota;
        this.zFinPelota = zFinPelota;
        this.velPelota = velPelota;
        this.angPelota = angPelota;
    }

    public pelota() {
        this.xIniPelota = 0;
        this.yIniPelota = 0;
        this.zIniPelota = 0;
        this.xFinPelota = 0;
        this.yFinPelota = 0;
        this.zFinPelota = 0;
        this.velPelota = 0;
        this.angPelota = 0;
    }

    public Integer getxIniPelota() {
        return xIniPelota;
    }

    public Integer getyIniPelota() {
        return yIniPelota;
    }

    public Integer getzIniPelota() {
        return zIniPelota;
    }

    public Integer getxFinPelota() {
        return xFinPelota;
    }

    public Integer getyFinPelota() {
        return yFinPelota;
    }

    public Integer getzFinPelota() {
        return zFinPelota;
    }

    public double getVelPelota() {
        return velPelota;
    }

    public double getAngPelota() {
        return angPelota;
    }
 
    public void setxIniPelota(Integer xIniPelota) {
        this.xIniPelota = xIniPelota;
    }

    public void setyIniPelota(Integer yIniPelota) {
        this.yIniPelota = yIniPelota;
    }

    public void setzIniPelota(Integer zIniPelota) {
        this.zIniPelota = zIniPelota;
    }

    public void setxFinPelota(Integer xFinPelota) {
        this.xFinPelota = xFinPelota;
    }

    public void setyFinPelota(Integer yFinPelota) {
        this.yFinPelota = yFinPelota;
    }

    public void setzFinPelota(Integer zFinPelota) {
        this.zFinPelota = zFinPelota;
    }

    public void setVelPelota(double velPelota) {
        this.velPelota = velPelota;
    }

    public void setAngPelota(double angPelota) {
        this.angPelota = angPelota;
    }
    
}
