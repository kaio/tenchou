//
//  TenChouAppDelegate.h
//  TenChou
//
//  Created by Caius Chance on 12/09/10.
//  Copyright Inspiready 2010. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MainViewController;

@interface TenChouAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    MainViewController *mainViewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet MainViewController *mainViewController;

@end

