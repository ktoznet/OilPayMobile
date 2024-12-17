import UIKit
import shared

@main
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?
        
    lazy var root: RootComponent = RootComponentKt.buildRootComponent(
        componentContext: DefaultComponentContext(
            lifecycle: ApplicationLifecycle(),
            stateKeeper: nil,
            instanceKeeper: nil,
            backHandler: nil
        )
    )
    
    override init() {
        GoogleMapsInit.shared.start()
        KoinInjector.shared.koinApp
    }

    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        if let window = window {
            window.rootViewController = MainKt.MainViewController(rootComponent: root)
            window.makeKeyAndVisible()
        }
        return true
    }
}
