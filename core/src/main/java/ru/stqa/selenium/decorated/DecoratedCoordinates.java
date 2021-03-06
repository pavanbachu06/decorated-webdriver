/*
 * Copyright 2016 Alexei Barantsev
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package ru.stqa.selenium.decorated;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Coordinates;

public class DecoratedCoordinates extends DecoratedChild<Coordinates,DecoratedWebDriver> implements Coordinates {

  public DecoratedCoordinates(final Coordinates coordinates, final DecoratedWebDriver driverWrapper) {
    super(coordinates, driverWrapper);
  }

  @Override
  public Point onScreen() {
    return getOriginal().onScreen();
  }

  @Override
  public Point inViewPort() {
    return getOriginal().inViewPort();
  }

  @Override
  public Point onPage() {
    return getOriginal().onPage();
  }

  @Override
  public Object getAuxiliary() {
    return getTopmostDecorated().wrapObject(getOriginal().getAuxiliary());
  }
}
