webpackJsonp([1,4],{

/***/ 153:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_router__ = __webpack_require__(53);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__(355);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(96);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_data__ = __webpack_require__(336);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_do__ = __webpack_require__(357);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_do___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_do__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_map__ = __webpack_require__(161);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_take__ = __webpack_require__(358);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_take___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_take__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return AuthService; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthGuard; });
/* unused harmony export AuthResult */
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var AuthService = (function () {
    function AuthService(http) {
        this.http = http;
        this.userAuthenticted = false;
    }
    AuthService.prototype.isAuthenticated = function () {
        return this.userAuthenticted;
    };
    AuthService.prototype.authenticate = function (data) {
        var _this = this;
        console.log('data', data);
        return this.http.post('api/auth', data)
            .map(function (res) {
            console.log('auth res', res);
            var err = res.json().error;
            var token = res.json().token;
            if (!err && token) {
                _this.setToken(token);
                return new AuthResult({ status: true, msg: 'User is Authenticated' });
            }
            return new AuthResult({ status: true, msg: err });
        }).catch(function (error) {
            console.error('catch', error);
            return __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].throw(new AuthResult({ status: false, msg: error.json().error }));
        });
    };
    AuthService.prototype.createUser = function (data) {
        var _this = this;
        console.log('', data);
        return this.http.post('api/users', data)
            .map(function (res) {
            console.log('auth res', res);
            var err = res.json().error;
            var token = res.json().token;
            if (!err && token) {
                _this.setToken(token);
                return new AuthResult({ status: true, msg: 'User is Authenticated' });
            }
            return new AuthResult({ status: true, msg: err });
        }).catch(function (error) {
            console.error('catch', error);
            return __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].throw(new AuthResult({ status: false, msg: error.json().error }));
        });
    };
    AuthService.prototype.logout = function () {
        this.resetToken();
    };
    AuthService.prototype.setToken = function (e) {
        this.userAuthenticted = true;
        this.token = e;
        __WEBPACK_IMPORTED_MODULE_4__app_data__["a" /* AppData */].token = e;
    };
    AuthService.prototype.resetToken = function () {
        this.userAuthenticted = false;
        this.token = '';
        __WEBPACK_IMPORTED_MODULE_4__app_data__["a" /* AppData */].token = '';
    };
    AuthService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* Http */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* Http */]) === 'function' && _a) || Object])
    ], AuthService);
    return AuthService;
    var _a;
}());
var AuthGuard = (function () {
    function AuthGuard(auth, router) {
        this.auth = auth;
        this.router = router;
    }
    AuthGuard.prototype.canActivate = function () {
        if (!this.auth.isAuthenticated()) {
            this.router.navigate(['/login']);
            return false;
        }
        else {
            return true;
        }
    };
    AuthGuard = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [AuthService, (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_0__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_0__angular_router__["c" /* Router */]) === 'function' && _a) || Object])
    ], AuthGuard);
    return AuthGuard;
    var _a;
}());
var AuthResult = (function () {
    function AuthResult(values) {
        if (values === void 0) { values = {}; }
        Object.assign(this, values);
    }
    return AuthResult;
}());
//# sourceMappingURL=AuthService.js.map

/***/ }),

/***/ 224:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(53);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Subject__ = __webpack_require__(9);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Subject___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_Subject__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__notification_type__ = __webpack_require__(337);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotificationService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var NotificationService = (function () {
    function NotificationService(router) {
        var _this = this;
        this.router = router;
        this.subject = new __WEBPACK_IMPORTED_MODULE_2_rxjs_Subject__["Subject"]();
        this.keepAfterRouteChange = false;
        // clear alert messages on route change unless 'keepAfterRouteChange' flag is true
        router.events.subscribe(function (event) {
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* NavigationStart */]) {
                if (_this.keepAfterRouteChange) {
                    // only keep for a single route change
                    _this.keepAfterRouteChange = false;
                }
                else {
                    // clear alert messages
                    _this.clear();
                }
            }
        });
    }
    NotificationService.prototype.getAlert = function () {
        return this.subject.asObservable();
    };
    NotificationService.prototype.success = function (message, cb, keepAfterRouteChange) {
        if (keepAfterRouteChange === void 0) { keepAfterRouteChange = false; }
        this.alert(__WEBPACK_IMPORTED_MODULE_3__notification_type__["a" /* AlertType */].Success, message, keepAfterRouteChange, cb);
    };
    NotificationService.prototype.error = function (message, keepAfterRouteChange) {
        if (keepAfterRouteChange === void 0) { keepAfterRouteChange = false; }
        this.alert(__WEBPACK_IMPORTED_MODULE_3__notification_type__["a" /* AlertType */].Error, message, keepAfterRouteChange);
    };
    NotificationService.prototype.info = function (message, keepAfterRouteChange) {
        if (keepAfterRouteChange === void 0) { keepAfterRouteChange = false; }
        this.alert(__WEBPACK_IMPORTED_MODULE_3__notification_type__["a" /* AlertType */].Info, message, keepAfterRouteChange);
    };
    NotificationService.prototype.warn = function (message, keepAfterRouteChange) {
        if (keepAfterRouteChange === void 0) { keepAfterRouteChange = false; }
        this.alert(__WEBPACK_IMPORTED_MODULE_3__notification_type__["a" /* AlertType */].Warning, message, keepAfterRouteChange);
    };
    NotificationService.prototype.alert = function (type, message, keepAfterRouteChange, cb) {
        if (keepAfterRouteChange === void 0) { keepAfterRouteChange = false; }
        if (cb === void 0) { cb = function () { }; }
        this.keepAfterRouteChange = keepAfterRouteChange;
        this.subject.next({ type: type, message: message, cb: cb });
    };
    NotificationService.prototype.onComplete = function (alert) {
        alert.cb();
    };
    NotificationService.prototype.clear = function () {
        // clear alerts
        this.subject.next();
    };
    NotificationService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* Router */]) === 'function' && _a) || Object])
    ], NotificationService);
    return NotificationService;
    var _a;
}());
//# sourceMappingURL=notification.service.js.map

/***/ }),

/***/ 336:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppData; });
var AppData = {
    token: ''
};
//# sourceMappingURL=app.data.js.map

/***/ }),

/***/ 337:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export Alert */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AlertType; });
var Alert = (function () {
    function Alert() {
    }
    return Alert;
}());
var AlertType;
(function (AlertType) {
    AlertType[AlertType["Success"] = 0] = "Success";
    AlertType[AlertType["Error"] = 1] = "Error";
    AlertType[AlertType["Info"] = 2] = "Info";
    AlertType[AlertType["Warning"] = 3] = "Warning";
})(AlertType || (AlertType = {}));
//# sourceMappingURL=notification.type.js.map

/***/ }),

/***/ 338:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(96);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__(161);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__todo__ = __webpack_require__(339);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TodoDataService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var TodoDataService = (function () {
    function TodoDataService(http) {
        this.http = http;
        this.lastId = 0;
        this.todos = [];
    }
    TodoDataService.prototype.addTodo = function (todo) {
        var _this = this;
        if (!todo.id) {
            var tempID_1 = ++this.lastId + "_tempID";
            todo.owner = { id: "58d805a86e5bd0a630585349", name: "digvijay", time: new Date };
            this.http.post('api/tasks', todo)
                .map(function (res) { return res.json(); })
                .subscribe(function (task) { return _this.updateTodoById(tempID_1, task); });
            todo.id = tempID_1;
        }
        this.todos.push(todo);
        console.log("todos : ", this.todos);
        return this;
    };
    TodoDataService.prototype.deleteTodoById = function (id) {
        console.log("todos : ", this.todos);
        this.todos = this.todos.filter(function (todo) { return todo.id !== id; });
        return this;
    };
    TodoDataService.prototype.updateTodoById = function (id, values) {
        if (values === void 0) { values = {}; }
        var todo = this.getTodoById(id);
        if (!todo) {
            return null;
        }
        Object.assign(todo, values);
        console.log("todos : ", this.todos);
        return todo;
    };
    TodoDataService.prototype.getAllTodos = function () {
        return this.todos;
    };
    TodoDataService.prototype.init = function () {
        var _this = this;
        this.loadTask()
            .subscribe(function (todos) { _this.todos = []; for (var _i = 0, todos_1 = todos; _i < todos_1.length; _i++) {
            var t = todos_1[_i];
            _this.todos.push(new __WEBPACK_IMPORTED_MODULE_3__todo__["a" /* Todo */](t));
        } }); //Old and Not Kewl Way
    };
    TodoDataService.prototype.getTodoById = function (id) {
        console.log("todos : ", this.todos);
        return this.todos.filter(function (todo) { return todo.id === id; }).pop();
    };
    TodoDataService.prototype.toggleTodoComplete = function (todo) {
        console.log("todos : ", this.todos);
        var updateTodo = this.updateTodoById(todo.id, { complete: !todo.complete });
        return updateTodo;
    };
    TodoDataService.prototype.loadTask = function () {
        return this.http.get('api/tasks')
            .map(function (res) { return res.json().tasks; });
    };
    TodoDataService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === 'function' && _a) || Object])
    ], TodoDataService);
    return TodoDataService;
    var _a;
}());
//# sourceMappingURL=todo-data.service.js.map

/***/ }),

/***/ 339:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Todo; });
var Todo = (function () {
    function Todo(values) {
        if (values === void 0) { values = {}; }
        this.title = '';
        this.complete = false;
        this.owner = { name: '', id: '', time: null };
        Object.assign(this, values);
    }
    return Todo;
}());
var Owner = (function () {
    function Owner(values) {
        if (values === void 0) { values = {}; }
        Object.assign(this, values);
    }
    return Owner;
}());
//# sourceMappingURL=todo.js.map

/***/ }),

/***/ 340:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__user_service__ = __webpack_require__(515);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__(53);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserComponent; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return User; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var UserComponent = (function () {
    function UserComponent(userService, _router) {
        this.userService = userService;
        this._router = _router;
    }
    UserComponent.prototype.ngOnInit = function () {
        this.userService.init();
    };
    Object.defineProperty(UserComponent.prototype, "users", {
        get: function () {
            return this.userService.getUserList();
        },
        enumerable: true,
        configurable: true
    });
    UserComponent.prototype.openUserProfile = function (id) {
        console.log("userid", id);
        this._router.navigate(['user-profile']);
    };
    UserComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-user',
            template: __webpack_require__(584),
            styles: [__webpack_require__(576)],
            providers: [__WEBPACK_IMPORTED_MODULE_1__user_service__["a" /* UserService */]]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__user_service__["a" /* UserService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__user_service__["a" /* UserService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === 'function' && _b) || Object])
    ], UserComponent);
    return UserComponent;
    var _a, _b;
}());
var User = (function () {
    function User(values) {
        if (values === void 0) { values = {}; }
        Object.assign(this, values);
    }
    return User;
}());
//# sourceMappingURL=user.component.js.map

/***/ }),

/***/ 341:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false,
    origin: "/"
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ 387:
/***/ (function(module, exports) {

function webpackEmptyContext(req) {
	throw new Error("Cannot find module '" + req + "'.");
}
webpackEmptyContext.keys = function() { return []; };
webpackEmptyContext.resolve = webpackEmptyContext;
module.exports = webpackEmptyContext;
webpackEmptyContext.id = 387;


/***/ }),

/***/ 388:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__(476);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__(507);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__(341);




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["a" /* enableProdMode */])();
}
__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 506:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__auth_AuthService__ = __webpack_require__(153);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__(53);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppComponent = (function () {
    function AppComponent(auth, router) {
        this.auth = auth;
        this.router = router;
    }
    /*get todos(){
      return this.todoDataService.getAllTodos();
    }*/
    AppComponent.prototype.logout = function () {
        this.auth.logout();
        this.router.navigate([""]);
    };
    Object.defineProperty(AppComponent.prototype, "isAuthenticated", {
        get: function () {
            return this.auth.isAuthenticated();
        },
        enumerable: true,
        configurable: true
    });
    AppComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__(578),
            styles: [__webpack_require__(570)],
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__auth_AuthService__["b" /* AuthService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__auth_AuthService__["b" /* AuthService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === 'function' && _b) || Object])
    ], AppComponent);
    return AppComponent;
    var _a, _b;
}());
//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ 507:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(150);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(53);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__(467);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_http__ = __webpack_require__(96);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__todo_data_service__ = __webpack_require__(338);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__auth_AuthService__ = __webpack_require__(153);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__app_component__ = __webpack_require__(506);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__todos_todos_component__ = __webpack_require__(513);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__user_user_component__ = __webpack_require__(340);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__login_login_component__ = __webpack_require__(510);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__signup_signup_component__ = __webpack_require__(512);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__http_http_factory__ = __webpack_require__(508);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__notification_notification_component__ = __webpack_require__(511);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__notification_notification_service__ = __webpack_require__(224);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__user_profile_user_profile_component__ = __webpack_require__(514);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
















var APP_ROUTES = [
    { path: '', redirectTo: 'users', pathMatch: 'full' },
    { path: 'users', component: __WEBPACK_IMPORTED_MODULE_9__user_user_component__["a" /* UserComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_6__auth_AuthService__["a" /* AuthGuard */]] },
    { path: 'user-profile', component: __WEBPACK_IMPORTED_MODULE_15__user_profile_user_profile_component__["a" /* UserProfileComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_6__auth_AuthService__["a" /* AuthGuard */]] },
    { path: 'todos', component: __WEBPACK_IMPORTED_MODULE_8__todos_todos_component__["a" /* TodosComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_6__auth_AuthService__["a" /* AuthGuard */]] },
    { path: 'signup', component: __WEBPACK_IMPORTED_MODULE_11__signup_signup_component__["a" /* SignupComponent */] },
    { path: 'login', component: __WEBPACK_IMPORTED_MODULE_10__login_login_component__["a" /* LoginComponent */] }
];
var HTTP_PROVIDER = {
    provide: __WEBPACK_IMPORTED_MODULE_4__angular_http__["a" /* Http */],
    useFactory: __WEBPACK_IMPORTED_MODULE_12__http_http_factory__["a" /* httpFactory */],
    deps: [__WEBPACK_IMPORTED_MODULE_4__angular_http__["b" /* XHRBackend */], __WEBPACK_IMPORTED_MODULE_4__angular_http__["c" /* RequestOptions */]]
};
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_2__angular_core__["b" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_7__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_8__todos_todos_component__["a" /* TodosComponent */],
                __WEBPACK_IMPORTED_MODULE_9__user_user_component__["a" /* UserComponent */],
                __WEBPACK_IMPORTED_MODULE_10__login_login_component__["a" /* LoginComponent */],
                __WEBPACK_IMPORTED_MODULE_11__signup_signup_component__["a" /* SignupComponent */],
                __WEBPACK_IMPORTED_MODULE_13__notification_notification_component__["a" /* NotificationComponent */],
                __WEBPACK_IMPORTED_MODULE_15__user_profile_user_profile_component__["a" /* UserProfileComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_http__["d" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* RouterModule */].forRoot(APP_ROUTES)
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_5__todo_data_service__["a" /* TodoDataService */], __WEBPACK_IMPORTED_MODULE_6__auth_AuthService__["b" /* AuthService */], __WEBPACK_IMPORTED_MODULE_6__auth_AuthService__["a" /* AuthGuard */], __WEBPACK_IMPORTED_MODULE_14__notification_notification_service__["a" /* NotificationService */], HTTP_PROVIDER],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_7__app_component__["a" /* AppComponent */]]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 508:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__http_service__ = __webpack_require__(509);
/* harmony export (immutable) */ __webpack_exports__["a"] = httpFactory;

function httpFactory(xhrBackend, requestOptions, router) {
    return new __WEBPACK_IMPORTED_MODULE_0__http_service__["a" /* HttpService */](xhrBackend, requestOptions, router);
}
//# sourceMappingURL=http.factory.js.map

/***/ }),

/***/ 509:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(96);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__(355);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__(341);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_data__ = __webpack_require__(336);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__(53);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HttpService; });
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var HttpService = (function (_super) {
    __extends(HttpService, _super);
    function HttpService(backend, defaultOptions, router) {
        console.log(" HttpService ");
        _super.call(this, backend, defaultOptions);
        this._router = router;
    }
    HttpService.prototype.request = function (url, options) {
        return _super.prototype.request.call(this, url, options).catch(this.onCatch);
    };
    HttpService.prototype.get = function (url, options) {
        url = this.updateUrl(url);
        return _super.prototype.get.call(this, url, this.getRequestOptionArgs(options));
    };
    HttpService.prototype.post = function (url, body, options) {
        url = this.updateUrl(url);
        console.log("post");
        return _super.prototype.post.call(this, url, body, this.getRequestOptionArgs(options));
    };
    HttpService.prototype.put = function (url, body, options) {
        url = this.updateUrl(url);
        return _super.prototype.put.call(this, url, body, this.getRequestOptionArgs(options));
    };
    HttpService.prototype.delete = function (url, options) {
        url = this.updateUrl(url);
        return _super.prototype.delete.call(this, url, this.getRequestOptionArgs(options));
    };
    HttpService.prototype.updateUrl = function (req) {
        console.log("Req Url " + req);
        //environment.origin = "http://localhost:3000/"
        console.log("environment.origin", __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].origin);
        __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].origin;
        return __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].origin + req;
    };
    HttpService.prototype.getRequestOptionArgs = function (options) {
        if (options == null) {
            options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]();
        }
        if (options.headers == null) {
            options.headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["e" /* Headers */]();
        }
        options.headers.append('X-APP-DVJ', 'db');
        if (__WEBPACK_IMPORTED_MODULE_4__app_data__["a" /* AppData */].token) {
            options.headers.append('Authorization', "Bearer " + __WEBPACK_IMPORTED_MODULE_4__app_data__["a" /* AppData */].token);
        }
        console.log("Set Request Options");
        return options;
    };
    HttpService.prototype.onCatch = function (error, caught) {
        console.log("Error", error);
        console.log("res [Ob]", caught);
        return __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].throw(error);
    };
    HttpService.prototype.intercept = function (observable) {
        var _this = this;
        return observable.catch(function (err, source) {
            if (err.status == 401) {
                _this._router.navigate(['/login']);
                return __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].empty();
            }
            else {
                return __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].throw(err);
            }
        });
    };
    HttpService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["f" /* ConnectionBackend */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["f" /* ConnectionBackend */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_5__angular_router__["c" /* Router */]) === 'function' && _c) || Object])
    ], HttpService);
    return HttpService;
    var _a, _b, _c;
}(__WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]));
//# sourceMappingURL=http.service.js.map

/***/ }),

/***/ 510:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__auth_AuthService__ = __webpack_require__(153);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__(53);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LoginComponent = (function () {
    function LoginComponent(auth, router) {
        this.auth = auth;
        this.router = router;
        this.isErrorDailog = false;
    }
    LoginComponent.prototype.onSubmit = function (formData) {
        var _this = this;
        console.log(formData);
        if (formData.valid) {
            this.auth.authenticate({ username: formData.value.loginId, password: formData.value.password })
                .subscribe(function (e) { if (e.status) {
                _this.router.navigate(['users']);
            } }, function (err) { _this.error = err.msg; _this.isErrorDailog = !err.status; });
        }
    };
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-login',
            template: __webpack_require__(579),
            styles: [__webpack_require__(571)]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__auth_AuthService__["b" /* AuthService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__auth_AuthService__["b" /* AuthService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === 'function' && _b) || Object])
    ], LoginComponent);
    return LoginComponent;
    var _a, _b;
}());
//# sourceMappingURL=login.component.js.map

/***/ }),

/***/ 511:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__notification_service__ = __webpack_require__(224);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__notification_type__ = __webpack_require__(337);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotificationComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var NotificationComponent = (function () {
    function NotificationComponent(notificationService) {
        this.notificationService = notificationService;
        this.message = '';
        this.showNotification = false;
        this.currAlert = null;
    }
    NotificationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.notificationService.getAlert().subscribe(function (alert) {
            if (alert) {
                _this.showNotification = true;
                _this.message = alert.message;
                _this.currAlert = alert;
            }
            console.log('alert', alert);
        });
    };
    NotificationComponent.prototype.removeAlert = function () {
        this.showNotification = false;
        this.message = '';
        if (this.currAlert) {
            this.notificationService.onComplete(this.currAlert);
        }
        this.notificationService.clear();
    };
    NotificationComponent.prototype.cssClass = function (alert) {
        if (!alert) {
            return;
        }
        // return css class based on alert type
        switch (alert.type) {
            case __WEBPACK_IMPORTED_MODULE_2__notification_type__["a" /* AlertType */].Success:
                return 'alert alert-success';
            case __WEBPACK_IMPORTED_MODULE_2__notification_type__["a" /* AlertType */].Error:
                return 'alert alert-danger';
            case __WEBPACK_IMPORTED_MODULE_2__notification_type__["a" /* AlertType */].Info:
                return 'alert alert-info';
            case __WEBPACK_IMPORTED_MODULE_2__notification_type__["a" /* AlertType */].Warning:
                return 'alert alert-warning';
        }
    };
    NotificationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-notification',
            template: __webpack_require__(580),
            styles: [__webpack_require__(572)]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__notification_service__["a" /* NotificationService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__notification_service__["a" /* NotificationService */]) === 'function' && _a) || Object])
    ], NotificationComponent);
    return NotificationComponent;
    var _a;
}());
//# sourceMappingURL=notification.component.js.map

/***/ }),

/***/ 512:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__(78);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__(53);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__user_user_component__ = __webpack_require__(340);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__auth_AuthService__ = __webpack_require__(153);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__notification_notification_service__ = __webpack_require__(224);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SignupComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var SignupComponent = (function () {
    function SignupComponent(_location, _auth, notificationService, _router) {
        this._location = _location;
        this._auth = _auth;
        this.notificationService = notificationService;
        this._router = _router;
    }
    SignupComponent.prototype.ngOnInit = function () {
    };
    SignupComponent.prototype.onSubmit = function (formData) {
        var _this = this;
        console.log(formData);
        if (formData.valid) {
            console.log('Form is Valid');
            var newUser = new __WEBPACK_IMPORTED_MODULE_3__user_user_component__["b" /* User */]({
                profile: { username: formData.value.username, picture: 'http://randomuser.me/api/portraits/med/men/83.jpg' },
                data: { password: formData.value.psw, oauth: 'qwerty' }
            });
            console.log('newUser', newUser);
            this._auth.createUser(newUser).subscribe(function (res) { _this.notificationService.success('User Created', function () { return _this._router.navigate(['login']); }); }, function (err) { _this.notificationService.error('User Faild'); });
        }
    };
    SignupComponent.prototype.onCancel = function () {
        this._location.back();
    };
    SignupComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-signup',
            template: __webpack_require__(581),
            styles: [__webpack_require__(573)]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_common__["a" /* Location */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_common__["a" /* Location */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__auth_AuthService__["b" /* AuthService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_4__auth_AuthService__["b" /* AuthService */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__notification_notification_service__["a" /* NotificationService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_5__notification_notification_service__["a" /* NotificationService */]) === 'function' && _c) || Object, (typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === 'function' && _d) || Object])
    ], SignupComponent);
    return SignupComponent;
    var _a, _b, _c, _d;
}());
//# sourceMappingURL=signup.component.js.map

/***/ }),

/***/ 513:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__todo__ = __webpack_require__(339);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__todo_data_service__ = __webpack_require__(338);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TodosComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TodosComponent = (function () {
    //todos:Todo[] = [];
    function TodosComponent(todoDataService) {
        this.todoDataService = todoDataService;
        this.title = 'app works!';
        this.newTodo = new __WEBPACK_IMPORTED_MODULE_1__todo__["a" /* Todo */]();
    }
    TodosComponent.prototype.addTodo = function () {
        console.log("Test log", this.newTodo);
        this.todoDataService.addTodo(this.newTodo);
        this.newTodo = new __WEBPACK_IMPORTED_MODULE_1__todo__["a" /* Todo */]();
    };
    TodosComponent.prototype.toggleTodoComplete = function (todo) {
        this.todoDataService.toggleTodoComplete(todo);
    };
    TodosComponent.prototype.removeTodo = function (todo) {
        this.todoDataService.deleteTodoById(todo.id);
    };
    TodosComponent.prototype.ngOnInit = function () {
        console.log("init the service ");
        this.todoDataService.init();
    };
    Object.defineProperty(TodosComponent.prototype, "todos", {
        get: function () {
            return this.todoDataService.getAllTodos();
        },
        enumerable: true,
        configurable: true
    });
    TodosComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-todos',
            template: __webpack_require__(582),
            styles: [__webpack_require__(574)],
            providers: [__WEBPACK_IMPORTED_MODULE_2__todo_data_service__["a" /* TodoDataService */]]
        }),
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__todo_data_service__["a" /* TodoDataService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__todo_data_service__["a" /* TodoDataService */]) === 'function' && _a) || Object])
    ], TodosComponent);
    return TodosComponent;
    var _a;
}());
//# sourceMappingURL=todos.component.js.map

/***/ }),

/***/ 514:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserProfileComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var UserProfileComponent = (function () {
    function UserProfileComponent() {
    }
    UserProfileComponent.prototype.ngOnInit = function () {
    };
    UserProfileComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-user-profile',
            template: __webpack_require__(583),
            styles: [__webpack_require__(575)]
        }), 
        __metadata('design:paramtypes', [])
    ], UserProfileComponent);
    return UserProfileComponent;
}());
//# sourceMappingURL=user-profile.component.js.map

/***/ }),

/***/ 515:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(96);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__(161);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var UserService = (function () {
    function UserService(http) {
        this.http = http;
        this.users = [];
    }
    UserService.prototype.init = function () {
        var _this = this;
        this.loadUser().subscribe(function (e) { return _this.users = e; });
    };
    UserService.prototype.getUserList = function () {
        return this.users;
    };
    UserService.prototype.loadUser = function () {
        return this.http.get('api/users').map(function (e) { return e.json().users; });
    };
    UserService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === 'function' && _a) || Object])
    ], UserService);
    return UserService;
    var _a;
}());
//# sourceMappingURL=user.service.js.map

/***/ }),

/***/ 570:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, ".nav-warpper .is-primary{\r\n    background-color: #00d1b2;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 571:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, ".form-container {\r\n    padding: 20px;\r\n}\r\n\r\n.form-container form{\r\n    margin: auto;\r\n    width: 500px;\r\n}\r\n\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 572:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 573:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, ".form-container {\r\n    padding: 20px;\r\n}\r\n\r\n.form-container form{\r\n    margin: auto;\r\n    width: 500px;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 574:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 575:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 576:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(35)();
// imports


// module
exports.push([module.i, "section.users-section{\r\n    padding: 20px 0;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ 578:
/***/ (function(module, exports) {

module.exports = "<div class=\"nav-warpper\">\r\n    <div class=\"container\">\r\n        <nav class=\"navbar\">\r\n\r\n            <div class=\"navbar-brand\">\r\n                <a class=\"navbar-item\" routerLink=\"todos\">\r\n                    <img src=\"http://free-icon-rainbow.com/i/icon_01606/icon_016060_256.png\" alt=\"The Todo App\" >\r\n                    Todos App\r\n                </a>\r\n\r\n                <div class=\"navbar-burger burger\" data-target=\"navMenuExample\">\r\n                    <span></span>\r\n                    <span></span>\r\n                    <span></span>\r\n                </div>\r\n\r\n            </div>\r\n\r\n            <div id=\"navMenuExample\" class=\"navbar-menu\">\r\n                <div class=\"navbar-end\">\r\n                    <a class=\"navbar-item \" routerLink=\"users\"><span class=\"emoji\">🎨</span>User</a>\r\n                    <a *ngIf=\"!isAuthenticated\" class=\"navbar-item \" routerLink=\"signup\"><span class=\"emoji\">❤️</span>Sign Up</a>\r\n                    <a *ngIf=\"isAuthenticated\" class=\"navbar-item \" href=\"javascript:void(0);\" (click)=\"logout()\"><span class=\"emoji\">❤️</span>Logout</a>\r\n                    <div class=\"navbar-item has-dropdown is-hoverable\">\r\n                        <div class=\"navbar-link\">\r\n                            More\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </nav>\r\n    </div>\r\n</div>\r\n\r\n<div>\r\n    <router-outlet></router-outlet>\r\n</div>\r\n<app-notification></app-notification>"

/***/ }),

/***/ 579:
/***/ (function(module, exports) {

module.exports = "<section class=\"hero is-primary\">\r\n  <div class=\"hero-body\">\r\n    <div class=\"container\">\r\n      <h1 class=\"title\">\r\n        Login\r\n      </h1>\r\n    </div>\r\n  </div>\r\n</section>\r\n<section class=\"login-form-wrapper\">\r\n  <div class=\"form-container container\">\r\n    <form #formData='ngForm' (ngSubmit)=\"onSubmit(formData)\">\r\n\r\n      <p class=\"has-text-danger\">\r\n          <span class=\"error is-danger\" *ngIf=\"error\">{{ error }}</span>\r\n      </p>\r\n\r\n      <div class=\"field\">\r\n        <label class=\"label\">Username</label>\r\n        <div class=\"control has-icons-left has-icons-right\">\r\n          <input type=\"text\" placeholder=\"Login Id..\" (ngModel)=\"loginId\" name=\"loginId\" class=\"input is-success\"  required>\r\n          <span class=\"icon is-small is-left\"><i class=\"fa fa-user\"></i></span>\r\n        </div>\r\n      </div>\r\n\r\n      <div class=\"field\">\r\n        <label class=\"label\">Password</label>\r\n        <div class=\"control has-icons-left has-icons-right\">\r\n          <input type=\"password\" placeholder=\"Password\" (ngModel)=\"password\" name=\"password\" class=\"input is-success\" required>\r\n          <span class=\"icon is-small is-left\"><i class=\"fa fa-key\"></i></span>\r\n        </div>\r\n      </div>\r\n      \r\n      <div class=\"control\">\r\n        <button type=\"submit\" [disabled]=\"!formData.valid\" class=\"button is-primary\">Log in</button>\r\n      </div>\r\n\r\n      <a routerLink=\"/signup\" class=\"alc\">Don't have an account?</a>\r\n    </form>\r\n  </div>\r\n</section>\r\n\r\n<div class=\"modal\" [class.is-active]=\"isErrorDailog\">\r\n  <div class=\"modal-background\"></div>\r\n  <div class=\"modal-card\">\r\n    <header class=\"modal-card-head\">\r\n      <p class=\"modal-card-title\">Alert</p>\r\n      <button class=\"delete\" (click)=\"isErrorDailog = false\"></button>\r\n    </header>\r\n    <section class=\"modal-card-body\">\r\n      {{ error }}\r\n    </section>\r\n    <footer class=\"modal-card-foot\">\r\n      <a class=\"button is-success\" (click)=\"isErrorDailog = false\" >Ok</a>\r\n    </footer>\r\n  </div>\r\n  <button class=\"modal-close is-large\" (click)=\"isErrorDailog = false\" ></button>\r\n</div>"

/***/ }),

/***/ 580:
/***/ (function(module, exports) {

module.exports = "<div class=\"modal\" [class.is-active]=\"showNotification\">\r\n  <div class=\"modal-background\"></div>\r\n  <div class=\"modal-card\">\r\n    <header class=\"modal-card-head\">\r\n      <p class=\"modal-card-title\">Alert</p>\r\n      <button class=\"delete\" (click)=\"removeAlert()\"></button>\r\n    </header>\r\n    <section class=\"modal-card-body\">\r\n      {{ message }}\r\n    </section>\r\n    <footer class=\"modal-card-foot\">\r\n      <a class=\"button is-success\" (click)=\"removeAlert()\" >Ok</a>\r\n    </footer>\r\n  </div>\r\n  <button class=\"modal-close is-large\" (click)=\"removeAlert()\" ></button>\r\n</div>"

/***/ }),

/***/ 581:
/***/ (function(module, exports) {

module.exports = "<section class=\"hero is-primary\">\r\n  <div class=\"hero-body\">\r\n    <div class=\"container\">\r\n      <h1 class=\"title\">\r\n        Sign Up\r\n      </h1>\r\n    </div>\r\n  </div>\r\n</section>\r\n<section class=\"login-form-wrapper\">\r\n  <div class=\"form-container container\">\r\n    <form #formData='ngForm' (ngSubmit)=\"onSubmit(formData)\">\r\n\r\n      <div class=\"field\">\r\n        <label class=\"label\">Username</label>\r\n        <div class=\"control has-icons-left has-icons-right\">\r\n          <input class=\"input is-success\" type=\"text\" placeholder=\"Username\" (ngModel)=\"username\" name=\"username\" required>\r\n          <span class=\"icon is-small is-left\"><i class=\"fa fa-user\"></i></span>\r\n          <span class=\"icon is-small is-right\"><i class=\"fa fa-check\"></i></span>\r\n        </div>\r\n        <p class=\"help is-success\">This username is available</p>\r\n      </div>\r\n\r\n      <div class=\"field\">\r\n        <label class=\"label\">Password</label>\r\n        <div class=\"control has-icons-left\">\r\n          <input class=\"input is-success\" type=\"password\" placeholder=\"Password\" (ngModel)=\"psw\" name=\"psw\" required>\r\n          <span class=\"icon is-small is-left\"><i class=\"fa fa-key\"></i></span>\r\n        </div>\r\n      </div>\r\n\r\n      <div class=\"field\">\r\n        <label class=\"label\">Repeat Password</label>\r\n        <div class=\"control has-icons-left\">\r\n          <input class=\"input is-success\" type=\"password\" placeholder=\"Repeat Password\" (ngModel)=\"pswrepeat\" name=\"pswrepeat\" required>\r\n          <span class=\"icon is-small is-left\"><i class=\"fa fa-key\"></i></span>\r\n        </div>\r\n      </div>\r\n\r\n      <div class=\"field\">\r\n        <div class=\"control\">\r\n          <label class=\"checkbox\">\r\n            <input type=\"checkbox\" checked=\"checked\">\r\n              By creating an account you agree to our <a href=\"javascript:void(0);\">Terms & Privacy</a>\r\n            </label>\r\n        </div>\r\n      </div>\r\n\r\n\r\n      <div class=\"field is-grouped\">\r\n        <div class=\"control\">\r\n          <button class=\"button is-primary\" type=\"submit\">Sign Up</button>\r\n        </div>\r\n        <div class=\"control\">\r\n          <button class=\"button is-link\" (click)=\"onCancel()\">Cancel</button>\r\n        </div>\r\n      </div>\r\n\r\n    </form>\r\n  </div>\r\n</section>"

/***/ }),

/***/ 582:
/***/ (function(module, exports) {

module.exports = "<!-- <section class=\"todoapp\">\r\n  <header class=\"header\">\r\n    <h1>Todos</h1>\r\n    <input class=\"new-todo\" placeholder=\"What needs to be done?\" autofocus=\"\" [(ngModel)]=\"newTodo.title\" (keyup.enter)=\"addTodo()\">\r\n  </header>\r\n  <section class=\"main\" *ngIf=\"todos.length > 0\">\r\n    <ul class=\"todo-list\">\r\n      <li *ngFor=\"let todo of todos\" [class.completed]=\"todo.complete\">\r\n        <div class=\"view\">\r\n          <input class=\"toggle\" type=\"checkbox\" (click)=\"toggleTodoComplete(todo)\" [checked]=\"todo.complete\">\r\n          <label>{{todo.title}}</label>\r\n          <button class=\"destroy\" (click)=\"removeTodo(todo)\"></button>\r\n        </div>\r\n      </li>\r\n    </ul>\r\n  </section>\r\n  <footer class=\"footer\" *ngIf=\"todos.length > 0\">\r\n    <span class=\"todo-count\"><strong>{{todos.length}}</strong> {{todos.length == 1 ? 'item' : 'items'}} left</span>\r\n  </footer>\r\n</section> -->\r\n<section class=\"hero is-primary\">\r\n  <div class=\"hero-body\">\r\n    <div class=\"container\">\r\n      <h1 class=\"title\">\r\n        Todos\r\n      </h1>\r\n    </div>\r\n  </div>\r\n</section>\r\n<section class=\"todos-wrapper\">\r\n  <div class=\"form-container container\">\r\n    <nav class=\"panel\">\r\n      <!-- <p class=\"panel-heading\">\r\n        repositories\r\n      </p> -->\r\n      <div class=\"panel-block\">\r\n        <p class=\"control has-icons-left\">\r\n          <input class=\"input is-small\" type=\"text\" placeholder=\"search\">\r\n          <span class=\"icon is-small is-left\">\r\n            <i class=\"fa fa-search\"></i>\r\n          </span>\r\n        </p>\r\n      </div>\r\n      <p class=\"panel-tabs\">\r\n        <a class=\"is-active\">all</a>\r\n        <a>done</a>\r\n        <a>not done</a>\r\n      </p>\r\n      <a class=\"panel-block is-active\">\r\n        <span class=\"panel-icon\">\r\n          <i class=\"fa fa-book\"></i>\r\n        </span>\r\n        bulma\r\n      </a>\r\n      <label *ngFor=\"let todo of todos\" [class.completed]=\"todo.complete\" class=\"panel-block\">\r\n        <input type=\"checkbox\" (click)=\"toggleTodoComplete(todo)\" [checked]=\"todo.complete\">\r\n        {{todo.title}}\r\n        <button class=\"destroy\" (click)=\"removeTodo(todo)\"></button>\r\n      </label>\r\n      <div class=\"panel-block\">\r\n        <button class=\"button is-primary is-outlined is-fullwidth\">\r\n          reset all filters\r\n        </button>\r\n      </div>\r\n    </nav>\r\n  </div>\r\n</section>"

/***/ }),

/***/ 583:
/***/ (function(module, exports) {

module.exports = "<section class=\"hero is-primary\">\r\n  <div class=\"hero-body\">\r\n    <div class=\"container\">\r\n      <h1 class=\"title\">\r\n        User Profile\r\n      </h1>\r\n    </div>\r\n  </div>\r\n</section>\r\n\r\n<section class=\"user-profile-section\">\r\n  <div class=\"container\">\r\n      <div class=\"field\">\r\n          <label class=\"label\">Name</label>\r\n          <div class=\"control\">\r\n            <input class=\"input\" type=\"text\" placeholder=\"Text input\">\r\n          </div>\r\n        </div>\r\n        \r\n        <div class=\"field\">\r\n          <label class=\"label\">Username</label>\r\n          <div class=\"control has-icons-left has-icons-right\">\r\n            <input class=\"input is-success\" type=\"text\" placeholder=\"Text input\" value=\"bulma\">\r\n            <span class=\"icon is-small is-left\">\r\n              <i class=\"fa fa-user\"></i>\r\n            </span>\r\n            <span class=\"icon is-small is-right\">\r\n              <i class=\"fa fa-check\"></i>\r\n            </span>\r\n          </div>\r\n          <p class=\"help is-success\">This username is available</p>\r\n        </div>\r\n        \r\n        <div class=\"field\">\r\n          <label class=\"label\">Email</label>\r\n          <div class=\"control has-icons-left has-icons-right\">\r\n            <input class=\"input is-danger\" type=\"email\" placeholder=\"Email input\" value=\"hello@\">\r\n            <span class=\"icon is-small is-left\">\r\n              <i class=\"fa fa-envelope\"></i>\r\n            </span>\r\n            <span class=\"icon is-small is-right\">\r\n              <i class=\"fa fa-warning\"></i>\r\n            </span>\r\n          </div>\r\n          <p class=\"help is-danger\">This email is invalid</p>\r\n        </div>\r\n        \r\n        <div class=\"field\">\r\n          <label class=\"label\">Subject</label>\r\n          <div class=\"control\">\r\n            <div class=\"select\">\r\n              <select>\r\n                <option>Select dropdown</option>\r\n                <option>With options</option>\r\n              </select>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        \r\n        <div class=\"field\">\r\n          <label class=\"label\">Message</label>\r\n          <div class=\"control\">\r\n            <textarea class=\"textarea\" placeholder=\"Textarea\"></textarea>\r\n          </div>\r\n        </div>\r\n        \r\n        <div class=\"field\">\r\n          <div class=\"control\">\r\n            <label class=\"checkbox\">\r\n              <input type=\"checkbox\">\r\n              I agree to the <a href=\"#\">terms and conditions</a>\r\n            </label>\r\n          </div>\r\n        </div>\r\n        \r\n        <div class=\"field\">\r\n          <div class=\"control\">\r\n            <label class=\"radio\">\r\n              <input type=\"radio\" name=\"question\">\r\n              Yes\r\n            </label>\r\n            <label class=\"radio\">\r\n              <input type=\"radio\" name=\"question\">\r\n              No\r\n            </label>\r\n          </div>\r\n        </div>\r\n        \r\n        <div class=\"field is-grouped\">\r\n          <div class=\"control\">\r\n            <button class=\"button is-primary\">Submit</button>\r\n          </div>\r\n          <div class=\"control\">\r\n            <button class=\"button is-link\">Cancel</button>\r\n          </div>\r\n        </div>\r\n  </div>\r\n</section>"

/***/ }),

/***/ 584:
/***/ (function(module, exports) {

module.exports = "<section class=\"hero is-primary\">\r\n  <div class=\"hero-body\">\r\n    <div class=\"container\">\r\n      <h1 class=\"title\">\r\n        Users\r\n      </h1>\r\n    </div>\r\n  </div>\r\n</section>\r\n<section class=\"users-section\" *ngIf=\"users.length > 0\">\r\n  <div class=\"container\">\r\n    <div class=\"box\" *ngFor=\"let user of users\">\r\n      <article class=\"media\">\r\n        <div class=\"media-left\">\r\n          <figure class=\"image is-64x64\">\r\n            <img src=\"{{user.profile.picture}}\" alt=\"Image\">\r\n          </figure>\r\n        </div>\r\n        <div class=\"media-content\">\r\n          <div class=\"content\">\r\n            <p>\r\n              <strong (click)=\"openUserProfile(user._id)\">John Smith</strong> <small>@{{user.profile.username}}</small> <small>31m</small>\r\n              <br> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur sit amet massa fringilla egestas.\r\n              Nullam condimentum luctus turpis.\r\n            </p>\r\n          </div>\r\n          <nav class=\"level is-mobile\">\r\n            <div class=\"level-left\">\r\n              <a class=\"level-item\">\r\n            <span class=\"icon is-small\"><i class=\"fa fa-reply\"></i></span>\r\n          </a>\r\n              <a class=\"level-item\">\r\n            <span class=\"icon is-small\"><i class=\"fa fa-retweet\"></i></span>\r\n          </a>\r\n              <a class=\"level-item\">\r\n            <span class=\"icon is-small\"><i class=\"fa fa-heart\"></i></span>\r\n          </a>\r\n            </div>\r\n          </nav>\r\n        </div>\r\n      </article>\r\n    </div>\r\n  </div>\r\n</section>"

/***/ }),

/***/ 851:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(388);


/***/ })

},[851]);
//# sourceMappingURL=main.bundle.js.map