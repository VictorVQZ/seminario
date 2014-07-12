/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cancha;

import java.io.Serializable;

/**
 *
 * @author KatherinC
 */
public class pelota implements Serializable{
    public Integer xIniPelota,yIniPelota,zIniPelota,xFinPelota,yFinPelota,zFinPelota;
    public double vx, vy, angPelota;

    public pelota(Integer xIniPelota, Integer yIniPelota, Integer zIniPelota, Integer xFinPelota, Integer yFinPelota, Integer zFinPelota, double velPelota, double angPelota) {
        this.xIniPelota = xIniPelota;
        this.yIniPelota = yIniPelota;
        this.zIniPelota = zIniPelota;
        this.xFinPelota = xFinPelota;
        this.yFinPelota = yFinPelota;
        this.zFinPelota = zFinPelota;
        this.angPelota = angPelota;
    }

    public pelota() {
        this.xIniPelota = 0;
        this.yIniPelota = 0;
        this.zIniPelota = 0;
        this.xFinPelota = 0;
        this.yFinPelota = 0;
        this.zFinPelota = 0;
        this.angPelota = 0;
    }
    
}
