import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MaterialModule} from './material/material.module';
import {BrowserAnimationsModule, NoopAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NewTestComponent } from './components/new-test/new-test.component';
import { MainNavComponent } from './components/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { TestRunsComponent } from './components/test-runs/test-runs.component';
import { DiscoverDevicesComponent } from './components/discover-devices/discover-devices.component';
import { RunComponent } from './components/run/run.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

import { MatVideoModule } from 'mat-video';

@NgModule({
  declarations: [
    AppComponent,
    NewTestComponent,
    MainNavComponent,
    TestRunsComponent,
    DiscoverDevicesComponent,
    RunComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    NoopAnimationsModule,
    FormsModule,
    HttpClientModule,
    LayoutModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatVideoModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
